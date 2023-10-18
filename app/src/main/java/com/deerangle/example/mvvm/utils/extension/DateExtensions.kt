package com.deerangle.example.mvvm.utils.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toIsoDateString(): String {
    val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return format.format(this)
}
