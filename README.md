# ~~Simple RecyclerView Touch Listener~~ RecyclerViewExtensions 
[![](https://jitpack.io/v/horaciocome1/simple-recyclerview-touch-listener.svg)](https://jitpack.io/#horaciocome1/simple-recyclerview-touch-listener) [![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)

## Getting Started
Android library that abstracts, and completely hide, the GestureDetector part of an recyclerview click, and press, events implementation. Leaving to the developer only the task of implementing what happens when such events occurs.
Compatible with androidx.
[See legacy code here](https://github.com/horaciocome1/simple-recyclerview-touch-listener/tree/version-2.2.0)

## Pre-requisites
To be able of testing and implementing this library, the developer should have a working recyclerview list with some data on it. Please refer to the sample app.

## Adding to your project
Lets start by adding a corresponding repository in your _root_ `build.gradle` file.
```gradle
allprojects {
    repositories {
        ..
        maven { url 'https://jitpack.io' }
    }
}
 ```
The next task is to add the dependency to your _app_ `build.gradle` file.<br>
[![](https://jitpack.io/v/horaciocome1/simple-recyclerview-touch-listener.svg)](https://jitpack.io/#horaciocome1/simple-recyclerview-touch-listener)
```gradle
dependencies {
    ..
    implementation 'com.github.horaciocome1:simple-recyclerview-touch-listener$VERSION'
}
```
Now you ready to go. You may want to _**sync your project**_ first.

## How to use (0.3.0 onwards)
[See legacy code here](https://github.com/horaciocome1/simple-recyclerview-touch-listener/tree/version-2.2.0)<br>
Inside the block, use `isSingleClick`, `isDoubleClick`, and `isLongClick` to filter your event. Then use `view` and `position` to find the itemView and the itemPosition respectively.
```kotlin
recyclerView.addGestureDetection {
    Log.d(TAG, "addGestureDetection isSingleClick=$isSingleClick")
    Log.d(TAG, "addGestureDetection isDoubleClick=$isDoubleClick")
    Log.d(TAG, "addGestureDetection isLongPress=$isLongPress")
    Log.d(TAG, "addGestureDetection view=$view")
    Log.d(TAG, "addGestureDetection position=$position")
}
```
There are also overflows for each individual gesture type which are implemented like this:
```kotlin
recyclerView.addGestureDetection {
    Log.d(TAG, "gesture detected")
    singleClick {
        Log.d(TAG, "gesture is single click")
        Log.d(TAG, "view=$view")
        Log.d(TAG, "position=$position")
    }
}
```
```kotlin
recyclerView.addGestureDetection {
    doubleClick {
        ..
    }
}
```
```kotlin
recyclerView.addGestureDetection {
    longPress {
        ..
    }
}
```

## Troubleshooting
1. You might face poor java support.
2. Would like to rollback to `0.2.0`? [See legacy code here](https://github.com/horaciocome1/simple-recyclerview-touch-listener/tree/version-2.2.0)

## Licenses
Copyright 2019 Horácio Flávio Comé Júnior

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## How to contribute
I am open to suggestions of any kind.
Please be expressive, so others so we'all will be able to understand each other!

## More
It is not just views that can have less boleirplate.
If you are on Kotlin Coroutines and Firebase Firestore please see [fireflow](https://github.com/horaciocome1/fireflow)