make sure compileSdkVersion and buildToolsVersion is correct in build.gradle
follow this guide if you have problems: https://spring.io/guides/gs/gradle-android/

from project root:
    gradlew build

from android-sdk folder:
    "AVD Mananger" -> start emulator
        adb install -r <project root>\build\outputs\apk\<apk file>
        
        
emulator speedup: http://stackoverflow.com/a/13856866

sources:
android gradle build: https://github.com/spring-guides/deprecate-gs-gradle-android/tree/master/complete
WebView example: https://developer.android.com/guide/webapps/webview.html