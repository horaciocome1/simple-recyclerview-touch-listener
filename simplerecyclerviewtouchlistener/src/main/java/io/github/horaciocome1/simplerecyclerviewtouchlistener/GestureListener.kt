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

class GestureListener(
    private val recyclerView: RecyclerView,
    private val onClick: (View, Int) -> Unit,
    private val onDoubleClick: (View, Int) -> Unit,
    private val onLongPress: (View, Int) -> Unit
) : GestureDetector.SimpleOnGestureListener() {

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        e?.run {
            val view = recyclerView.findChildViewUnder(x, y)
            if (view != null) onClick(view, recyclerView.getChildAdapterPosition(view))
        }
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        e?.run {
            val view = recyclerView.findChildViewUnder(x, y)
            if (view != null) onDoubleClick(view, recyclerView.getChildAdapterPosition(view))
        }
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        e?.run {
            val view = recyclerView.findChildViewUnder(x, y)
            if (view != null) onLongPress(view, recyclerView.getChildAdapterPosition(view))
        }
    }
}