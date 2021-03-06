package com.hafizdwp.alphabet_checklist

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.hafizdwp.alphabet_checklist.data.ViewModelFactory


inline fun <reified T : ViewModel> AppCompatActivity.obtainViewModel() =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(T::class.java)

inline fun <reified VM : ViewModel> Fragment.obtainViewModel() =
        ViewModelProviders.of(requireActivity(), ViewModelFactory.getInstance(requireActivity().application)).get(VM::class.java)


val gson by lazy { Gson() }
val gsonPretty by lazy { GsonBuilder().setPrettyPrinting().create() }


inline fun <reified T> makeType() = object : TypeToken<T>() {}.type

fun <T> T.toJson(pretty: Boolean = false): String =
        if (pretty) gsonPretty.toJson(this)
        else gson.toJson(this)

inline fun <reified T> String.fromJson(): T = gson.fromJson(this, makeType<T>())

/**
 * Log ext
 * */
fun log(msg: String,
        tag: String? = null) {
    Log.d(tag ?: "mytag", msg)
}

fun logError(msg: String,
             tag: String? = null) {
    Log.e(tag ?: "mytag", msg)
}

fun logWarning(msg: String,
               tag: String? = null) {
    Log.w(tag ?: "mytag", msg)
}

/**
 * Ez toast
 * */
var mToast: Toast? = null

fun AppCompatActivity.toast(msg: String?) {
    if (!msg.isNullOrBlank()) {
        mToast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        mToast?.show()
    }
}

/**
 * @param msg    message
 * @param length Toast.LENGTH_LONG or Toast.LENGTH_SHORT or int numbers
 * */
fun AppCompatActivity.toastSpammable(msg: String?,
                                     length: Int = Toast.LENGTH_LONG) {
    if (!msg.isNullOrBlank()) {
        if (mToast != null) mToast?.cancel()
        mToast = Toast.makeText(this, msg, length)
        mToast?.show()
    }
}

fun Context.toast(msg: String?, length: Int = Toast.LENGTH_LONG) {
    if (!msg.isNullOrBlank()) {
        mToast = Toast.makeText(this, msg, length)
        mToast?.show()
    }
}

fun Context.toastSpammable(msg: String?) {
    if (!msg.isNullOrBlank()) {
        if (mToast != null) mToast?.cancel()
        mToast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        mToast?.show()
    }
}

fun Fragment.toast(msg: String?) {
    (requireActivity() as? AppCompatActivity)?.toast(msg)
}

fun Fragment.toastSpammable(msg: String?,
                            length: Int = Toast.LENGTH_LONG) {
    (requireActivity() as? AppCompatActivity)?.toastSpammable(msg, length)
}

fun BottomSheetDialog.disableBottomSheetSwipe() {
    try {
        val behaviorField = this.javaClass.getDeclaredField("behavior")
        behaviorField.isAccessible = true
        val behavior = behaviorField[this] as? BottomSheetBehavior<*>
        behavior?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    }
}