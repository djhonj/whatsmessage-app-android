package com.whatsmessage.ui.component

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class ModalDialog(
    context: Activity,
    private val title: String = "",
    private val message: String = "",
    private val confirmText: String = "ok",
    private val cancelText: String? = null,
    private val canceledOnTouch: Boolean = false,

    private val listenerConfirm: (dialog: DialogInterface, id: Int) -> Unit = { _, _ -> },
    private val listenerCancel: (dialog: DialogInterface, id: Int) -> Unit = { _, _ -> }
) {
    private val builder = AlertDialog.Builder(context)

    fun show() {
        create()
        builder.show()
    }

    private fun create() {
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(confirmText, listenerConfirm)

        if (cancelText != null) {
            builder.setNegativeButton(cancelText, listenerCancel)
        }

        builder.create()
            .setCanceledOnTouchOutside(true)
    }
}