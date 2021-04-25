package com.ulanapp.bonus.utils

import java.util.*

fun Date.convertDateToDayMonth(): String {
    val cal: Calendar = Calendar.getInstance()
    cal.time = this

    val month: Int = cal.get(Calendar.MONTH)
    val day: String = cal.get(Calendar.DAY_OF_MONTH).toString()
    val monthWithZero = String.format("%02d", month);
    return "$day.$monthWithZero"
}