package com.minibrowser.newberoser.recyclerviewcoildemo

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

data class LandscapeData(val id: String,val url:String)
@BindingAdapter("android:image")
fun loadImage(image: ImageView, imageUrl: String) {
    image.load(imageUrl)
}
//Image Changing Code
