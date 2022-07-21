package com.example.gaditeksocialapp.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.domain.model.Social
import com.example.gaditeksocialapp.R
import com.example.gaditeksocialapp.ui.main.social.SocialListAdapter

@BindingAdapter("loadImage")
fun ImageView.loadImage(src: String?) {
    load(src) {
        crossfade(true)
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_placeholder)
        transformations(CircleCropTransformation())
    }
}
