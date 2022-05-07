package com.example.newsapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setDate")
fun setDate(view: TextView, date: String?) {
    if (date != null) {
        val result = date.split("T")
        val newDate = "${result[0]} ${result[1].substring(0, result[1].lastIndexOf(":"))} "
        view.text = newDate
    }
}