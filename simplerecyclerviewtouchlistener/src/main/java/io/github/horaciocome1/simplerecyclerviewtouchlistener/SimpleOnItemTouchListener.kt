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

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SimpleOnItemTouchListener(
        recyclerView: RecyclerView,
        listener: (View, Int) -> Unit,
        type: Int
) : RecyclerView.OnItemTouchListener {

    private val gestureListener = GestureListener(recyclerView, listener, type)
    private var gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(recyclerView.context, gestureListener)
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {  }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {  }

}