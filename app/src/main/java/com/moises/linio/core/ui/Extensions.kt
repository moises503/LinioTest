package com.moises.linio.core.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun Context.toast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ViewGroup.inflate(layoutId : Int) : View = LayoutInflater.from(context)
    .inflate(layoutId, this, false)


fun AppCompatActivity.setAppToolbar(
    toolbar: Toolbar,
    toolbarTitle: TextView,
    title: String,
    homeAsUpEnabled: Boolean = false
) {
    this.setSupportActionBar(toolbar)
    this.supportActionBar?.setDisplayShowTitleEnabled(false)
    toolbarTitle.text = title
    this.supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
}
