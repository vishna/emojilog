package dev.vishna.emojilog

typealias LogFormatter = (Log.Level, Any?) -> Unit

/**
 * Emoji powered logger
 *
 * Usage
 *
 * ```kotlin
 * Log.warn.."This is not happening!!1"
 * ```
 */
open class Log(val formatter: LogFormatter) {

    inner class Level(val value: String, val log: Log = this) {
        operator fun <T> rangeTo(message: T) {
            formatter(this, message as Any?)
        }
    }

    val verbose = "📜".asLevel()
    val debug = "🤖".asLevel()
    val info = "ℹ️".asLevel()
    val warn = "🚨".asLevel()
    val error = "💥".asLevel()

    val edit = "✏️".asLevel()
    val conf = "⚙️".asLevel()
    val skip = "⏭".asLevel()
    val save = "💾".asLevel()
    val tool = "🛠".asLevel()
    val exit = "👋".asLevel()
    val beer = "🍺".asLevel()

    fun String.asLevel() = Level(this)
}

fun defaultLogger(printStackTrace: Boolean = false) = Log { level, message ->
    val throwable = if (message is Throwable) { message } else { null }
    val m = throwable?.message ?: message

    when (level) {
        level.log.error -> System.err.println("${level.value} $m")
        else -> println("${level.value} $m")
    }

    if (printStackTrace) throwable?.printStackTrace(System.err)
}

/**
 * try-catch anything + auto logging. use wisely
 */
inline fun <T> safe(level: Log.Level? = null, block: () -> T?) : T? {
    return try {
        block()
    } catch (t: Throwable) {
        if (level != null) {
            level..t
        }
        null
    }
}