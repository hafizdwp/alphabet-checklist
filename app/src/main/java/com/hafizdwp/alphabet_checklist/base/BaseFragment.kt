package com.hafizdwp.alphabet_checklist.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

/**
 * @author hafizdwp
 * 18/05/2021
 **/
abstract class BaseFragment<T: AppCompatActivity> : Fragment() {

    lateinit var mActivity: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivity = requireActivity() as T
    }

    fun <T> LiveData<T>.observe(action: (T?) -> Unit) {
        observe(viewLifecycleOwner, {
            action.invoke(it)
        })
    }
}