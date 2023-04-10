package com.example.postrequest.data.autorization

import android.content.Context

class AuthManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun setIsAuthenticated(isAuthenticated: Boolean) {
        sharedPreferences.edit().putBoolean("is_authenticated", isAuthenticated).apply()
    }

    fun getIsAuthenticated(): Boolean {
        return sharedPreferences.getBoolean("is_authenticated", false)
    }
}