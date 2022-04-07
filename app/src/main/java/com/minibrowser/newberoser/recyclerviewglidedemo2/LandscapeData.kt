package com.minibrowser.newberoser.recyclerviewglidedemo2

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class LandscapeData(val id: String,val url:String)
@BindingAdapter("android:image")
fun loadImage(image: ImageView, imageUrl: String) {
    Glide.with(image.context)
        .load(imageUrl)
        .into(image)
}
