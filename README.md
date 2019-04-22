# Simple RecyclerView Touch Listener 
[![](https://jitpack.io/v/horaciocome1/simple-recyclerview-touch-listener.svg)](https://jitpack.io/#horaciocome1/simple-recyclerview-touch-listener) . [![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

## Getting Started
Android library that abstracts, and completely hide, the GestureDetector part of an recyclerview click, and press, events implementation. Leaving to the developer only the task of implementing what happens when such events occurs.
Compatible with androidx.

## Pre-requisites
To be able of testing and implementing this library, the developer should have a working recyclerview list with some data on it.

## Adding to your project
Lets start by adding a corresponding repository in your _root_ `build.gradle` file.
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
The next task is to add the dependency to your _app_ `build.gradle` file.
```gradle
	dependencies {
          ...
	        implementation 'com.github.horaciocome1:simple-recyclerview-touch-listener:0.2.2'
	}
```
Now you ready to go. You might want to _**sync your project**_ first.

## How to use
```kotlin
    recyclerView.addOnItemClickListener { view, position -> 
        // handle clicks
    }
    
    recyclerView.addOnItemDoubleClickListener { view, position ->
        // handle double clicks
    }
    
    recyclerView.addOnItemLongPressListener { view, position -> 
        // handle long presses
    }
```

Its not mandatory to implement all at once. Perhaps you just need to handle long presses. In that case you should only implement `setOnItemLongPressListener( ... )`.
```kotlin
    recyclerView.addOnItemLongPressListener { view, position -> 
        // handle long presses
    }
```

## Troubleshooting
You might face poor java support.

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

## Simple RecyclerView Utils
This is part of a series of libraries that pretend to make recyclerView usage more easy.
For a adapter please see [Simple RecyclerView Adapter](https://github.com/horaciocome1/simple-recyclerview-adapter)