package dev.vishna.emojilog.git

import dev.vishna.emojilog.Log

/**
 * emojilog implementation of Emoji-Log (An Emoji Git commit log messages spec standard.)
 * found here: https://github.com/ahmadawais/Emoji-Log
 *
 * SIDENOTE: Emoji-Log was first with the name and its something a bit different from what this library
 * is doing. Nonetheless paying tribute here to Ahmad Awais' library
 */

// Use when you add something entirely new. E.g. 📦 NEW: Add Git ignore file
val Log.new
    get() =  { "📦 NEW:" } lvl "new"

// Use when you improve/enhance piece of code like refactoring etc. E.g. 👌 IMPROVE: Remote IP API Function
val Log.improve
    get() =  { "👌 IMPROVE:" } lvl "improve"

// Use when you fix a bug — need I say more? E.g. 🐛 FIX: Case converter
val Log.fix
    get() =  { "🐛 FIX:" } lvl "fix"

// Use when you add documentation like README.md, or even inline docs. E.g. 📖 DOC: API Interface Tutorial
val Log.doc
    get() =  { "📖 DOC:" } lvl "doc"

// Use when you release a new version. E.g. 🚀 RELEASE: Version 2.0.0
val Log.release
    get() =  { "🚀 RELEASE:" } lvl "release"

// Use when you fix a bug — need I say more? E.g. 🐛 FIX: Case converter
val Log.test
    get() =  { "✅ TEST:" } lvl "test"