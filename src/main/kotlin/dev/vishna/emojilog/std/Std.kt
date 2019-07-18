package dev.vishna.emojilog.std

import dev.vishna.emojilog.Log

val Log.edit
    get() = { "✏️" } lvl "edit"

val Log.conf
    get() = { "⚙️" } lvl "conf"

val Log.skip
    get() = { "⏭" } lvl "skip"

val Log.save
    get() = { "💾" } lvl "save"

val Log.tool
    get() = { "🛠" } lvl "tool"

val Log.wave
    get() = { "👋" } lvl "wave"

val Log.beer
    get() = { "🍺" } lvl "beer"

val Log.alert
    get() = { "🚨" } lvl "alert"

val Log.boom
    get() = { "💥" } lvl "boom"

val Log.shrug
    get() = { "🤷" } lvl "shrug"

val Log.nope
    get() = { "🙅" } lvl "nope"

fun defaultLogger(printStackTrace: Boolean = false) = Log { level, message ->
    val throwable = if (message is Throwable) { message } else { null }
    val m = throwable?.message ?: message

    when (level) {
        level.log.boom -> System.err.println("${level.value} $m")
        else -> println("${level.value} $m")
    }

    if (printStackTrace) throwable?.printStackTrace(System.err)
}