# A Scala implementation of the Android training exercise

This is a Scala implementation of [the Android training exercises](http://developer.android.com/training).

What you need to do to make it work ...

* install sbt (e.g. `sudo port install sbt`)
* install ant (e.g. `sudo port install apache-ant`)
* install the Android SDK and download platform level 19 (this is the one I am using)
* clone this repo to `<dir of your choice>`
* you either need to set ANDROID_HOME or you need to run `android project update -p <dir of your choice>/scala-android-first`
* create an [avd](http://developer.android.com/tools/devices/managing-avds-cmdline.html) and start the emulator (this can take a while)
    * `android avd create --name MyFirstAvd --target "Google Inc.:Google APIs:19"`
    * `emulator -avd MyFirstAvd -gpu on`
* copy `android-support-v4.jar` from `${ANDROID_HOME}/extras/android/support/v4` into `<dir of your choice>/scala-android-first/libs`
* run `sbt install`
* open `My First App` on the emulator
* watch what is going on with `adb shell logcat <filter of your choice>`

... and you should be in business.
