package dev.vishna.emojilog

import dev.vishna.emojilog.android.*
import dev.vishna.emojilog.safe.safely
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class LogTest {
    @Test
    fun test() {
        val mockLogger = MockLogger()
        val logHistory = mockLogger.history
        val log = mockLogger.log

        data class Foo(val bar : Int)

        log.debug.."Hello World"
        log.verbose..null
        log.info..Foo(bar = 42)

        log.error.safely {
            4/0
        }.shouldBeNull()

        log.error.safely {
            4/4
        }!! `should be equal to` 1

        logHistory[0] `should be equal to` "🤖 Hello World"
        logHistory[1] `should be equal to` "📜 null"
        logHistory[2] `should be equal to` "ℹ️ Foo(bar=42)"
        logHistory[3] `should be equal to` "💥 java.lang.ArithmeticException: / by zero"
        logHistory.size `should be equal to` 4
    }
}