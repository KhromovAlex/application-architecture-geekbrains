package com.example.applicationarchitecturegeekbrains

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

fun ImageView.loadNetworkImage(url: String, @DrawableRes placeholderError: Int): RequestBuilder<Drawable> =
    Glide.with(this)
        .load(url)
        .error(placeholderError)
