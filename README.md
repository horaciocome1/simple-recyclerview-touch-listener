# Simple RecyclerView Touch Listener 
[![](https://jitpack.io/v/horaciocome1/simple-recyclerview-touch-listener.svg)](https://jitpack.io/#horaciocome1/simple-recyclerview-touch-listener)[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

## Getting Started
Android library that abstracts, and completely hide, the GestureDetector part of an recyclerview click, and press, events implementation. Leaving to the developer only the task of implementing what happens when such events occurs.
Compatible with androidx.

## Pre-requesites
To be able of testing and implementig this library, the developer should have a working recyclerview list with some data on it.

## Adding to your project
Lets start by adding a corresponding repository in your _root_ `build.gradle` file. (prefer below all other)
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
The next task is to add the dependecy to your _app_ `build.gradle` file.
```gradle
	dependencies {
          ...
	        implementation 'com.github.horaciocome1:simple-recyclerview-touch-listener:0.1.5'
	}
```
Now you ready to go. Except that you should _**sync your project**_ first.

### Do not use with app compart or support design
As mention on IO18, android support libraries will not be updated anymore, thats the main reason ive moved to androidx and new material design libraries. That's why if you have any appcompat or design support library as dependency the build will fail. Because the androidx on these app will conflict with android support on your app.
Dont panic, you can use version 0.1.0 with the old support libraries. But dont espect that to be as much fiendly as these new build.
```gradle
	dependencies {
          ...
	        implementation 'com.github.horaciocome1:simple-recyclerview-touch-listener:0.1.0'
	}
```
Do not try to implement as follow. The object `SimpleRecyclerViewOnItemTouchListener` is still the same. Just instanciate the class passing necessary arguments. Makeuseof code completion to help you. I am wondering if it is necessary to do a separate lib for suppor appcompat. Email me if you thinking on that.

## How to use
I suggest calling custom **addSimpleTouchListener()** recyclerview extension, because its more easy to get the _recyclerview_.
```kotlin
recyclerView.addSimpleTouchListener( SimpleRecyclerViewOnItemTouchListener().apply {
    setOnItemClickListener { view, i -> /* handle clicks */ }
    setOnItemDoubleClickListener { view, i -> /* handle double clicks */ }
    setOnItemLongPressListener { view, i -> /* handle long presses */ }
})
```

If you want to call default **addOnItemTouchListener()**, you need to specify the recyclerview.
```kotlin
recyclerview.addSimpleTouchListener( SimpleRecyclerViewOnItemTouchListener().apply {
    setOnItemClickListener { view, i -> /* handle clicks */ }
    setOnItemDoubleClickListener { view, i -> /* handle double clicks */ }
    setOnItemLongPressListener { view, i -> /* handle long presses */ }
    this.recyclerview = recyclerview
})
```

Its not mandatory to implement all at once. Pheraphs you only need to handle long presses. In that case you should only implement `setOnItemLongPressListener( ... )`.
```kotlin
this.addSimpleTouchListener( SimpleRecyclerViewOnItemTouchListener().apply {
    setOnItemClickListener { view, i -> /* handle clicks */ }
})
```

### Java
I'll submit soon.
```kotlin

```

### Troubleshooting
Naturally, you need to implement those callback or nothing is done.
```kotlin
// this is what you need to a void
recyclerView.addSimpleTouchListener(SimpleRecyclerViewOnItemTouchListener())
```

### "Build or sinchronization failed!"
Please reference to the part on the start where i talked about support libraries.

## Licenses
   Copyright 2018 Horácio Flávio Comé Júnior

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

## Simple RecyclerView Utils
This is part of a serie of libraries that pretend to make recyclerview usage more easy.
For a adapter please see [Simple RecyclerView Adapter](https://github.com/horaciocome1/simple-recyclerview-adapter)