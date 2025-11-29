package com.3dplayer.core.database

import android.content.Context
import android.content.SharedPreferences

class PlayerSettings(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("player_settings", Context.MODE_PRIVATE)

    var theme: String?
        get() = sharedPreferences.getString("theme", "default")
        set(value) { sharedPreferences.edit().putString("theme", value).apply() }

    var playbackPreference: String?
        get() = sharedPreferences.getString("playback_preference", "normal")
        set(value) { sharedPreferences.edit().putString("playback_preference", value).apply() }

    var is3DEnabled: Boolean
        get() = sharedPreferences.getBoolean("3d_enabled", false)
        set(value) { sharedPreferences.edit().putBoolean("3d_enabled", value).apply() }

    var subtitleConfiguration: String?
        get() = sharedPreferences.getString("subtitle_configuration", "none")
        set(value) { sharedPreferences.edit().putString("subtitle_configuration", value).apply() }

    var languagePreference: String?
        get() = sharedPreferences.getString("language_preference", "en")
        set(value) { sharedPreferences.edit().putString("language_preference", value).apply() }
}