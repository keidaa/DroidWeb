This project is an attempt at creating a skeleton web application that runs on a webview in a android app.

How to build
-
The barebones android app is created using [this](https://spring.io/guides/gs/gradle-android/) guide so refeer to it if you having diffucilties building.

The tldr version is:
1. Install JDK and the android SDK + download the API you wish to target
2. Add JDK and android SDK to your path
3. Make sure compileSdkVersion and buildToolsVersion is correct in build.gradle
4. From project root: `gradlew build`

To debug the generated apk:
From android-sdk folder:
* "AVD Mananger" -> start emulator
* `adb install -r <project root>\build\outputs\apk\<apk file>`
* or for usb debugging: `adb -d install -r <project root>\build\outputs\apk\<apk file>`
        
Tip: [speed up emulator x10](http://stackoverflow.com/a/13856866)

*Sources*:
* [android gradle build]( https://github.com/spring-guides/deprecate-gs-gradle-android/tree/master/complete)
* [WebView example](https://developer.android.com/guide/webapps/webview.html)
