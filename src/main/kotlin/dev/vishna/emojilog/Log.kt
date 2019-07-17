package dev.vishna.emojilog

typealias LogFormatter = (Log.Level, Any?) -> Unit

/**
 * Emoji powered logger
 *
 * Usage
 *
 * ```kotlin
 * val Log.warn
 *   get() = "💥" lvl "warn"
 *
 * log.warn.."This is not happening!!1"
 * ```
 */
class Log(private val logFormatter: LogFormatter) {

    inner class Level(val value: String, val extra: Any? = null, val log: Log = this) {
        operator fun <T> rangeTo(message: T) {
            logFormatter(this, message as Any?)
        }
    }

    private val extensions = mutableMapOf<String, Level>()

    infix fun String.lvl(key: String): Level {
        return extensions[key] ?: Level(this).apply {
            extensions[key] = this
        }
    }

    infix fun String.lvl(key: Pair<String, Any>): Level {
        return extensions[key.first] ?: Level(value = this, extra = key.second).apply {
            extensions[key.first] = this
        }
    }
}