package com.hafizdwp.alphabet_checklist.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

/**
 * @author hafizdwp
 * 18/05/2021
 **/
abstract class BaseFragment<T : AppCompatActivity> : Fragment() {

    @get:LayoutRes
    abstract val layoutRes: Int
    abstract fun onViewReady(view: View)

    lateinit var mActivity: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivity = requireActivity() as T
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewReady(view)
    }


    fun <T> LiveData<T>.observe(action: (T?) -> Unit) {
        observe(viewLifecycleOwner, {
            action.invoke(it)
        })
    }
}