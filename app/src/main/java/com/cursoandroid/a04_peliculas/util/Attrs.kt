package com.cursoandroid.a04_peliculas.util

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

@BindingAdapter("app:imgUrl")
fun setImageByUrl(img: ImageView, url:String){
    Picasso.with(img.context)
            .load(Uri.parse(url))
            .into(img)
}

@BindingAdapter("app:dateFormat")
fun setDateText(txt: TextView, date: Date){
    txt.text = dateFormat.format(date)
}