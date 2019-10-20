[![](https://jitpack.io/v/zainfikrih/jsonloader-library.svg)](https://jitpack.io/#zainfikrih/jsonloader-library)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ab5f6e4c77a0474280b46883ce17092b)](https://www.codacy.com/manual/zainfikrih/jsonloader-library?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zainfikrih/jsonloader-library&amp;utm_campaign=Badge_Grade)
[![HitCount](http://hits.dwyl.io/zainfikrih/jsonloader-library.svg)](http://hits.dwyl.io/zainfikrih/jsonloader-library)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-JSONLoader%20Library-orange.svg?style=flat)](https://android-arsenal.com/details/1/7916)

# JSONLoader Library
![Imgur](https://i.imgur.com/xczU7nd.png)
A simple Android library to open JSON from assets

## Download
[![JitPack](https://img.shields.io/jitpack/v/github/zainfikrih/jsonloader-library?label=Download&logoColor=yellowgreen)](https://jitpack.io/#zainfikrih/jsonloader-library)

Grab the latest dependencies through Gradle, add it to your build.gradle with:
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
and:

```gradle
dependencies {
    implementation 'com.github.zainfikrih:jsonloader-library:{latest version}'
}
```

## Usage
Put the json file in the assets package on the android project (src / main / assets / filename.json).
For more information, see [Where do I place the 'assets' folder in Android Studio?](https://stackoverflow.com/questions/18302603/where-do-i-place-the-assets-folder-in-android-studio)

Get JSON as a string:
```java
  String jsonString = JSONLoader.with(getApplicationContext()).fileName("filename.json").get();
```

Get JSON as JSON Object:
```java
  JSONObject jsonObject = JSONLoader.with(getApplicationContext()).fileName("filename.json").getAsJSONObject();
```

Get JSON as JSON Array:
```java
  JSONArray jsonArray = JSONLoader.with(getApplicationContext()).fileName("filename.json").getAsJSONArray();
```

For some examples, see the sample App.

## License
```license
Copyright 2019 Zain Fikri H

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
     
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
