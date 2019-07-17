package dev.vishna.emojilog

class MockLogger {
    val history = mutableListOf<String>()
    val log = Log { level, any ->
        history += "${level.value} $any"
    }
}