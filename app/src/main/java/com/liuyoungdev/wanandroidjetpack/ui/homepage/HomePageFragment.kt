package com.liuyoungdev.wanandroidjetpack.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liuyoungdev.wanandroidjetpack.R

/**
 * author： yang
 * date  ： 2020/12/2
 */
class HomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_homepage, container, false)

    }

}