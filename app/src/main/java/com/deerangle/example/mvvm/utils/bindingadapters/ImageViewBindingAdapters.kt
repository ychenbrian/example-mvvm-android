package com.deerangle.example.mvvm.utils.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.deerangle.example.mvvm.R

@BindingAdapter("bind:imageUrl")
fun loadImage(
    view: ImageView,
    imageUrl: String?,
) {
    Glide.with(view.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_image)
        .dontAnimate()
        .into(view)
}
