package com.liuyoungdev.wanandroidjetpack.ui.main

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.liuyoungdev.wanandroidjetpack.R
import com.liuyoungdev.wanandroidjetpack.ui.base.BaseActivity
import com.liuyoungdev.wanandroidjetpack.ui.homemine.HomeMineFragment
import com.liuyoungdev.wanandroidjetpack.ui.homepage.HomePageFragment
import com.liuyoungdev.wanandroidjetpack.ui.homeplaza.HomePlazaFragment
import com.liuyoungdev.wanandroidjetpack.ui.homesystem.HomeSystemFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var previousTimeMillis: Long = 0L
    private var lastPosition: Int = 0;
    private val fragments = arrayListOf<Fragment>()
    private var currentFragment: Fragment? = null
    private var hideFragment: Fragment? = null
    override fun setLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        fragments.apply {
            add(HomePageFragment())
            add(HomeSystemFragment())
            add(HomePlazaFragment())
            add(HomeMineFragment())
        }
        seleFragment(0)
        bottom_navigation_view.setOnNavigationItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.home_page -> seleFragment(0)
                R.id.home_system -> seleFragment(1)
                R.id.home_plaza -> seleFragment(2)
                else -> seleFragment(3)
            }
        }


    }

    private fun seleFragment(position: Int): Boolean {
        bottom_navigation_view.menu.getItem(position).isChecked = true
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        currentFragment = fragmentManager.findFragmentByTag("fragment$position")
        hideFragment = fragmentManager.findFragmentByTag("fragment$lastPosition")
        if (lastPosition != position) {
            hideFragment?.let { beginTransaction.hide(it) }
            if (currentFragment == null) {
                currentFragment = fragments[position]
                currentFragment?.let {
                    beginTransaction.add(
                        R.id.layout_frame,
                        it,
                        "fragment$position"
                    )
                }
            } else {
                currentFragment?.let { beginTransaction.show(it) }
            }
        }
        if (lastPosition == position) {
            if (currentFragment == null) {
                currentFragment = fragments[position]
                currentFragment?.let {
                    beginTransaction.add(
                        R.id.layout_frame,
                        it,
                        "fragment$position"
                    )
                }
            }
        }
        beginTransaction.commit()
        lastPosition = position
        return true
    }

    override fun initData() {

    }


    //伴生对象，相当于java中的静态对象
    companion object {
        fun actionStart(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)

        }
    }

    override fun onBackPressed() {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - previousTimeMillis < 2000) {
            super.onBackPressed()
        } else {
            SmartSnackbar.get(this).show(R.string.again_exit)
            previousTimeMillis = currentTimeMillis
        }
    }
}

