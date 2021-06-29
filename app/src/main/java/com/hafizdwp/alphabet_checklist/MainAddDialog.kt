package com.hafizdwp.alphabet_checklist

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.StyleRes
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @author hafizdwp
 * 29/06/2021
 **/
class MainAddDialog(context: Context,
                    private val actionListener: MainActionListener,
                    @StyleRes theme: Int = R.style.Theme_Design_BottomSheetDialog) : BottomSheetDialog(context, theme) {

    init {
        buildView()
    }

    lateinit var etAdd: EditText
    lateinit var btnAdd: Button

    private lateinit var view: View

    private fun buildView() {
        view = layoutInflater.inflate(R.layout.main_add_dialog, null)
        this.setContentView(view)
        this.disableBottomSheetSwipe()

        behavior.isDraggable = false

        view.apply {
            etAdd = findViewById(R.id.et_add)
            btnAdd = findViewById(R.id.btn_add)
        }

        btnAdd.setOnClickListener {
            actionListener.addName(etAdd.text.toString())
            dismiss()
        }
    }

    override fun show() {
        super.show()
        etAdd.setText("")
        etAdd.requestFocus()
    }
}