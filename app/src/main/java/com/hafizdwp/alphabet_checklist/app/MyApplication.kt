package com.hafizdwp.alphabet_checklist.app

import android.app.Application

/**
 * @author hafizdwp
 * 20/05/2021
 **/
class MyApplication : Application() {

    companion object {
        private lateinit var instance: MyApplication

        fun getInstance(): MyApplication = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}