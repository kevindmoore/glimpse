package com.journeyai.glimpse

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
  private val prefs: SharedPreferences = context.getSharedPreferences("Category",
    Context.MODE_PRIVATE)

  fun saveString(key: String, value: String) {
    prefs.edit().putString(key, value).apply()
  }

  fun getString(key: String): String? {
    return prefs.getString(key, null)
  }

  fun saveInt(key: String, value: Int) {
    prefs.edit().putInt(key, value).apply()
  }

  fun getInt(key: String): Int? {
    return prefs.getInt(key, 0)
  }

  fun hasKey(key: String): Boolean {
    return prefs.contains(key)
  }

}
