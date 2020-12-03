package com.liuyoungdev.wanandroidjetpack.ui.base

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.liuyoungdev.wanandroidjetpack.R

/**
 * author： yang
 * date  ： 2020/12/1
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initImmersionBar()
        setSmartSnackBar()
        initActivity()

    }

    private fun initActivity() {
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()


    abstract fun setLayoutId(): Int

    private fun setSmartSnackBar() {
        SmartSnackbar.setting()
            .backgroundColorRes(R.color.white)
            .dismissOnLeave(true)
    }

    open fun initImmersionBar() {
        immersionBar {
            statusBarColor(R.color.green)
        }


    }

}