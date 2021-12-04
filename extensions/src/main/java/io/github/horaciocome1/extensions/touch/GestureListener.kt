/*
 * Copyright 2021 Horácio Flávio Comé Júnior
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package io.github.horaciocome1.extensions.touch

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GestureListener(
    private val recyclerView: RecyclerView,
    private val listener: OnGesture,
) : GestureDetector.SimpleOnGestureListener() {

    override fun onSingleTapUp(event: MotionEvent?) =
        event?.onEvent { view, position ->
            GestureOperation(view, position, isSingleClick = true)
        } ?: false

    override fun onLongPress(e: MotionEvent?) {
        e?.onEvent { view, position -> GestureOperation(view, position, isLongPress = true) }
    }

    override fun onDoubleTap(e: MotionEvent?) =
        e?.onEvent { view, position ->
            GestureOperation(view, position, isDoubleClick = true)
        } ?: false

    private fun MotionEvent.onEvent(
        buildOperation: (view: View, position: Int) -> GestureOperation
    ) = recyclerView.findChildViewUnder(x, y)?.let { view ->
        val position = recyclerView.getChildAdapterPosition(view)
        val details = buildOperation(view, position)
        listener.onGesture(details)
    } != null
}
