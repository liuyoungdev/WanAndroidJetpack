package com.liuyoungdev.wanandroidjetpack.ui

import com.liuyoungdev.wanandroidjetpack.R
import com.liuyoungdev.wanandroidjetpack.ui.base.BaseActivity
import com.liuyoungdev.wanandroidjetpack.ui.main.MainActivity

/**
 * author： yang
 * date  ： 2020/12/1
 */
class SplashActivity : BaseActivity() {
    override fun initData() {
    }

    override fun initView() {
        MainActivity.actionStart(this)
        finish()
    }

    override fun setLayoutId(): Int = R.layout.activity_splash


}