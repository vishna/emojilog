package dev.vishna.emojilog.android

import dev.vishna.emojilog.Log

val Log.verbose
    get() = { "📜" } lvl "verbose"

val Log.debug
    get() = { "🤖" } lvl "debug"

val Log.info
    get() = { "ℹ️" } lvl "info"

val Log.warn
    get() = { "🚨" } lvl "warn"

val Log.error
    get() = { "💥" } lvl "error"

val Log.wtf
    get() = { "💥💥💥" } lvl "error"