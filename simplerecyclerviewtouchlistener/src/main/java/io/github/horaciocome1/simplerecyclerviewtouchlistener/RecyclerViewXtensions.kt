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

import android.view.View
import androidx.recyclerview.widget.RecyclerView

private var onClick = { _: View, _:Int -> Unit }
private var onDoubleClick = { _: View, _:Int -> Unit }
private var onLongPress = { _: View, _:Int -> Unit }

fun RecyclerView.addSimpleTouchListener() {
    this.addOnItemTouchListener(SimpleOnItemTouchListener(this, onClick, onDoubleClick, onLongPress))
}

fun RecyclerView.setOnClick(callback: (View, Int) -> Unit) { onClick = callback }

fun RecyclerView.setOnDoubleClick(callback: (View, Int) -> Unit) { onDoubleClick = callback }

fun RecyclerView.setOnLongPress(callback: (View, Int) -> Unit) { onLongPress = callback }