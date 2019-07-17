package dev.vishna.emojilog.safe

import dev.vishna.emojilog.Log

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

/**
 * just like safe above, but an extension on top of the logger
 */
inline fun <T> Log.Level.safely(block: () -> T?) : T? = safe(level = this, block = block)