/*
 *    Copyright 2018 Horácio Flávio Comé Júnior
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific la
 */

package io.github.horaciocome1.simplerecyclerviewtouchlistener

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SimpleRecyclerViewOnItemTouchListener(private val context: Context) : RecyclerView.OnItemTouchListener {

    private lateinit var recyclerView: RecyclerView
    private var onClick = { _: View, _: Int -> Unit }
    private var onDoubleClick = { _: View, _: Int -> Unit }
    private var onLongPress = { _: View, _: Int -> Unit }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        GestureDetector(context, MyGestureListener(onClick, onDoubleClick, onLongPress, recyclerView))
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        return true
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

    fun setOnItemClickListener(onClick: (View, Int) -> Unit) {
        this.onClick = onClick
    }

    fun setOnItemDoubleClickListener(onDoubleClick: (View, Int) -> Unit) {
        this.onDoubleClick = onDoubleClick
    }

    fun setOnItemLongPressListener(onLongPress: (View, Int) -> Unit) {
        this.onLongPress = onLongPress
    }

    fun setRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }



}