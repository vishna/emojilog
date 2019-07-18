package dev.vishna.emojilog

typealias LogFormatter = (Log.Level, Any?) -> Unit

/**
 * Emoji powered logger
 *
 * Usage
 *
 * ```kotlin
 * val Log.warn
 *   get() = { "💥" } lvl "warn"
 *
 * log.warn.."This is not happening!!1"
 * ```
 */
class Log(private val logFormatter: LogFormatter) {

    inner class Level(val value: Any, val log: Log = this) {
        operator fun <T> rangeTo(message: T) {
            logFormatter(this, message as Any?)
        }
    }

    private val extensions = mutableMapOf<String, Level>()

    infix fun (() -> Any).lvl(key: String): Level {
        return extensions[key] ?: Level(this()).apply {
            extensions[key] = this
        }
    }
}