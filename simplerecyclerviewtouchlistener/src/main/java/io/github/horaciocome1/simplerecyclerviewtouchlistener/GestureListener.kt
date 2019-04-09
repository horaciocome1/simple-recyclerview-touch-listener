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
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.DOUBLE_TAP
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.LONG_PRESS
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.SINGLE_TAP_UP

class GestureListener(
        private val recyclerView: RecyclerView,
        private val listener: (View, Int) -> Unit,
        private val type: Int
) : GestureDetector.SimpleOnGestureListener() {

    override fun onSingleTapUp(e: MotionEvent?) = e?.getChild(SINGLE_TAP_UP) ?: true

    override fun onDoubleTap(e: MotionEvent?) = e?.getChild(DOUBLE_TAP) ?: true

    override fun onLongPress(e: MotionEvent?) {
        e?.getChild(LONG_PRESS)
    }

    private fun MotionEvent.getChild(t: Int): Boolean {
        recyclerView.findChildViewUnder(x, y)?.let {
            if (type == t)
                listener(it, recyclerView.getChildAdapterPosition(it))
        }
        return true
    }

}