package com.example.newsapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImage")
fun loadImage(view: ImageView, url: String?) {
    if (url != null) {
        Picasso.get().load(url).into(view)
    }
}
