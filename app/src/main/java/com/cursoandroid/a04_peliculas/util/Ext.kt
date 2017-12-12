package com.cursoandroid.a04_peliculas.util

import android.content.Intent
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlin.reflect.KClass

fun ViewGroup.inflate(@LayoutRes layout: Int): View =
        LayoutInflater.from(context).inflate(layout, this, false)

fun AppCompatActivity.toastRK(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT)
}

inline fun <reified T:AppCompatActivity>AppCompatActivity.startActivityRK(vararg extras: Pair<String, Any>){
    val intent = Intent(this, T::class.java)
    extras.forEach {
        val value = it.second
        when(value){
            is Int -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
        }
    }
    startActivity(intent)
}