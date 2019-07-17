package dev.vishna.emojilog

import dev.vishna.emojilog.git.*
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class GitLogTest {
    @Test
    fun test() {
        val mockLogger = MockLogger()
        val gitHistory = mockLogger.history
        val git = mockLogger.log

        git.new.."Add Git ignore file"
        git.improve.."Remote IP API Function"
        git.fix.."Case converter"
        git.doc.."API Interface Tutorial"
        git.release.."Version 2.0.0"
        git.test.."Mock User Login/Logout"

        gitHistory[0] `should be equal to` "📦 NEW: Add Git ignore file"
        gitHistory[1] `should be equal to` "👌 IMPROVE: Remote IP API Function"
        gitHistory[2] `should be equal to` "🐛 FIX: Case converter"
        gitHistory[3] `should be equal to` "📖 DOC: API Interface Tutorial"
        gitHistory[4] `should be equal to` "🚀 RELEASE: Version 2.0.0"
        gitHistory[5] `should be equal to` "✅ TEST: Mock User Login/Logout"
        gitHistory.size `should be equal to` 6
    }
}