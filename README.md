# Emoji Log

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
val exception = IllegalStateException("Things went weird!")
val log = defaultLogger()

log.error..exception // prints: 💥 Things went weird!
```