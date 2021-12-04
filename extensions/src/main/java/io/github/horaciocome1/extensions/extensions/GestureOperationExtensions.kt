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

import io.github.horaciocome1.extensions.touch.GestureOperation
import io.github.horaciocome1.extensions.touch.GestureOperationLite

val GestureOperation.lite
    get() = GestureOperationLite(view, position)

/**
 * Block is only called in case the gesture is of type single click
 */
inline fun GestureOperation.singleClick(block: GestureOperationLite.() -> Unit) {
    if (isSingleClick) {
        lite.block()
    }
}

/**
 * Block is only called in case the gesture is of type double click
 */
inline fun GestureOperation.doubleClick(block: GestureOperationLite.() -> Unit) {
    if (isDoubleClick) {
        lite.block()
    }
}

/**
 * Block is only called in case the gesture is of type long press
 */
inline fun GestureOperation.longClick(block: GestureOperationLite.() -> Unit) {
    if (isLongPress) {
        lite.block()
    }
}
