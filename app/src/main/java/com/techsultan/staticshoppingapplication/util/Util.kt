package com.techsultan.staticshoppingapplication.util

import java.text.NumberFormat
import java.util.Locale

object Util {

    fun Double.toCurrency(): String {
        val format = NumberFormat.getCurrencyInstance(Locale("en", "NG"))
        return format.format(this)
    }
}