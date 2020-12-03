package com.liuyoungdev.wanandroidjetpack

import android.app.Application
import com.coder.zzq.smartshow.core.SmartShow
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

/**
 * author： yang
 * date  ： 2020/12/1
 */
@HiltAndroidApp
class WanAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        SmartShow.init(this)

    }

}