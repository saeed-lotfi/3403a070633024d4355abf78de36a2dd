package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util

import android.content.Context
import android.widget.Toast


    fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
