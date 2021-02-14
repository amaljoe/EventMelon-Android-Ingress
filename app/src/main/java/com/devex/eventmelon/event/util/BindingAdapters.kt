package com.devex.eventmelon.event.util

import android.graphics.Color
import android.graphics.ColorFilter
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.devex.eventmelon.R

@BindingAdapter("favourite")
fun bindImage(imgButton: ImageButton, favourite: Boolean?) {
    favourite?.let {
        if(favourite) {
            imgButton.setColorFilter(ContextCompat.getColor(imgButton.context, R.color.white), android.graphics.PorterDuff.Mode.SRC_IN)
            imgButton.background = ContextCompat.getDrawable(imgButton.context, R.drawable.pink_full_rounded_rect_12)
        } else {
            imgButton.setColorFilter(ContextCompat.getColor(imgButton.context, R.color.grey_500), android.graphics.PorterDuff.Mode.SRC_IN)
            imgButton.background = ContextCompat.getDrawable(imgButton.context, R.drawable.full_rounded_rect_12)
        }
    }
}