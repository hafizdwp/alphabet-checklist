package com.hafizdwp.alphabet_checklist

import android.os.Bundle
import com.hafizdwp.alphabet_checklist.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction().apply {
            val fragment = MainFragment()
            add(R.id.frame, fragment)
            show(fragment)
        }.commit()
    }
}