package com.devshiv.ecelldeskregistration.utils

import android.content.Context
import com.devshiv.fishtankecell.utils.Variables

object SharedPrefsManager {

//    fun getName(context: Context): String? {
//        return context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE)
//            .getString(Variables.NAME_FB_TAG, "")
//    }
//
//    fun setName(context: Context, token: String?) {
//        context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE).edit()
//            .putString(Variables.NAME_FB_TAG, token).apply()
//    }
//
//    fun getEmail(context: Context): String? {
//        return context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE)
//            .getString(Variables.EMAIL_FB_TAG, "")
//    }
//
//    fun setEmail(context: Context, token: String?) {
//        context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE).edit()
//            .putString(Variables.EMAIL_FB_TAG, token).apply()
//    }
//
//    fun getPassword(context: Context): String? {
//        return context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE)
//            .getString(Variables.PASSWORD_FB_TAG, "")
//    }
//
//    fun setPassword(context: Context, token: String?) {
//        context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE).edit()
//            .putString(Variables.PASSWORD_FB_TAG, token).apply()
//    }

    fun getLoginStatus(context: Context): Boolean {
        return context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE)
            .getBoolean(Variables.LOGGED_IN_PREFS, false)
    }

    fun setLoginStatus(context: Context, status: Boolean) {
        context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE).edit()
            .putBoolean(Variables.LOGGED_IN_PREFS, status).apply()
    }

    fun getOnBoardStatus(context: Context): Boolean {
        return context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE)
            .getBoolean(Variables.ON_BOARD_PREFS, false)
    }

    fun setOnBoardStatus(context: Context, status: Boolean) {
        context.getSharedPreferences(Variables.SHARED_PREFS, Context.MODE_PRIVATE).edit()
            .putBoolean(Variables.ON_BOARD_PREFS, status).apply()
    }
}
