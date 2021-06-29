package com.hafizdwp.alphabet_checklist.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData

/**
 * @author hafizdwp
 * 18/05/2021
 **/
abstract class BaseActivity : AppCompatActivity() {

    fun <T> LiveData<T>.observe(action: (T?) -> Unit) {
        observe(this@BaseActivity, {
            action.invoke(it)
        })
    }
}