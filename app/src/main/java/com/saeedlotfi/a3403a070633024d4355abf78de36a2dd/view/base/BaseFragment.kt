package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<dataBinding : ViewDataBinding,>(
    private val layout: Int,
) : Fragment() {

    private var _binding: dataBinding? = null
    val binding: dataBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layout, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    /**
     * initialize the fragment
     */
    abstract fun init()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}