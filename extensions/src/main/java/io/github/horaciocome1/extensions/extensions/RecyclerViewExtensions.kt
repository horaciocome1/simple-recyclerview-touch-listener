/*
 * Copyright 2021 Horácio Flávio Comé Júnior
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package io.github.horaciocome1.extensions.extensions

import androidx.recyclerview.widget.RecyclerView
import io.github.horaciocome1.extensions.touch.GestureOperation
import io.github.horaciocome1.extensions.touch.OnGesture
import io.github.horaciocome1.extensions.touch.TouchListener

/**
 * Never call this in onStart or onResume
 * Abstracts the whole ItemTouchListener implementation and exposes only the
 * GestureOperation that occurred<br>
 */
fun RecyclerView.addGestureDetection(block: GestureOperation.() -> Unit) {
    val touchListener = TouchListener(
        this,
        object : OnGesture {

            override fun onGesture(operation: GestureOperation) {
                operation.block()
            }
        }
    )
    addOnItemTouchListener(touchListener)
}
