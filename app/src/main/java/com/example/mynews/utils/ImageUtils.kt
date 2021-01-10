package com.example.mynews.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageUtils {
    companion object {
        fun loadImage(imageRef: String?, holderResId: Int, imageView: ImageView) {
            Glide.with(imageView).load(imageRef)
                .apply(RequestOptions().placeholder(holderResId))
                .fitCenter()
                .centerCrop()
                .into(imageView)
        }
    }
}