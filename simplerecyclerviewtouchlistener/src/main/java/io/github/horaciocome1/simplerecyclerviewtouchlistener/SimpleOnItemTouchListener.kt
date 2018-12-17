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
 *    See the License for the specific language governing permissions and limitations under the License.
 */

package io.github.horaciocome1.simplerecyclerviewtouchlistener

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SimpleOnItemTouchListener(
    recyclerView: RecyclerView,
    onClick: (View, Int) -> Unit,
    onDoubleClick: (View, Int) -> Unit,
    onLongPress: (View, Int) -> Unit
) : RecyclerView.OnItemTouchListener {

    private var gestureListener = GestureListener(recyclerView, onClick, onDoubleClick, onLongPress)
    private var gestureDetector: GestureDetector

    init { gestureDetector = GestureDetector(recyclerView.context, gestureListener) }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {  }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {  }

}