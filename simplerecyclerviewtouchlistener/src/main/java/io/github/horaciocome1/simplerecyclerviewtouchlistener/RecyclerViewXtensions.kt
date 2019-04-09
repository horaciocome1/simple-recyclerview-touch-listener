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

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.DOUBLE_TAP
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.LONG_PRESS
import io.github.horaciocome1.simplerecyclerviewtouchlistener.SimpleRecyclerView.SINGLE_TAP_UP

fun RecyclerView.addOnItemClickListener(listener: (View, Int) -> Unit) {
    addOnItemTouchListener(SimpleOnItemTouchListener(this, listener, SINGLE_TAP_UP))
}

fun RecyclerView.addOnItemDoubleClickListener(listener: (View, Int) -> Unit) {
    addOnItemTouchListener(SimpleOnItemTouchListener(this, listener, DOUBLE_TAP))
}

fun RecyclerView.addOnItemLongPressListener(listener: (View, Int) -> Unit) {
    addOnItemTouchListener(SimpleOnItemTouchListener(this, listener, LONG_PRESS))
}