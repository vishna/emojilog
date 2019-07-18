# emojilog

Extensible emoji powered logger of anything. Written in Kotlin for the lols.

![](https://media.giphy.com/media/xUPGcz2H1TXdCz4suY/giphy.gif)

## Getting started

This repository is hosted via [jitpack](https://jitpack.io/) since it's by far the easiest delivery method while also being pretty transparent to the developer.

Make sure you have added jitpack to the list of your repositories:

```kotlin
maven("https://jitpack.io")
```

Then simply add the `emojilog` dependency

```kotlin
dependencies {
    compile("com.github.vishna:emojilog:master-SNAPSHOT")
}
```

## Example usage


```kotlin
import dev.vishna.emojilog.std.defaultLogger // default logger
import dev.vishna.emojilog.android.* // predefined "android" like extensions

val log = defaultLogger()

log.info.."Hello world!" // prints: ℹ️ Hello world!
log.error..IllegalStateException("Whoops!") // prints: 💥 Whoops!
log.wtf..IllegalStateException("💩 hit the fan") // prints: 💥💥💥 💩 hit the fan!
```

### Defining own log extensions

```kotlin
val Log.shrug
  get() = { "🤷" } lvl "shrug"
```

__NOTE__: ```"shrug"``` here is a key by which this extension will be cached by the `Log` instance

If you would want to do some "extra something" with the output e.g. style the color of the text, you can pass extra parameter of `Any` type as a pair

```kotlin
val Log.fail
  get() = { "❌" to 0xFF0000 } lvl "fail"
```

__NOTE__: This won't magically create colored text for you, you will need to handle this in your own, custom logger.

*{Using closure}* to avoid evaluating expression whenever the getter is getting called 😉 

### Defining own logger

Here's how you could integrate emojilog in your Android App

```kotlin
Log { level, any ->
    val throwable = any as? Throwable
    with(level.log) {
        when (level) {
            verbose -> android.util.Log.v(level.value, "$any")
            debug -> android.util.Log.i(level.value, "$any")
            info -> android.util.Log.i(level.value, "$any")
            warn -> android.util.Log.w(level.value, "$any", throwable)
            error -> android.util.Log.e(level.value, "$any", throwable)
            wtf -> android.util.Log.wtf(level.value, "$any", throwable)
            else -> android.util.Log.d(level.value, "$any")
        }
    }
}
```

![Screenshot 2019-07-17 at 14 24 46](https://user-images.githubusercontent.com/121164/61375346-ffb71b00-a89e-11e9-8d19-e2b1f82ad7d9.png)

...if only Android's logcat supported emojis 😭

### More examples

Please check out tests 👉 [LogTest](https://github.com/vishna/emojilog/blob/master/src/test/kotlin/dev/vishna/emojilog/LogTest.kt)

### Acknowledgments

While creating this library I wasn't aware of [Emoji-Log](https://github.com/ahmadawais/Emoji-Log) by [ahmadawais](https://ahmadawais.com/). The scope of that project is different and focuses on formatting of git commit messages while this one is meant to be logger for simple pet projects written in Kotlin. Anyway, as a tribute to his project, I added [git extensions](https://github.com/vishna/emojilog/blob/master/src/main/kotlin/dev/vishna/emojilog/git/Git.kt) and some [tests](https://github.com/vishna/emojilog/blob/master/src/test/kotlin/dev/vishna/emojilog/GitLogTest.kt) for it.

🍺 Cheers!