package com.football.challengemyteams.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class CustomSP {
    companion object{
        private var sp:SharedPreferences?=null

        @Volatile private var instance:CustomSP?=null
        private val lock=Any()

        operator fun invoke(context: Context):CustomSP= instance ?: synchronized(lock){
            instance?: createCustomSP(context).also {
                instance=it
            }
        }

        private fun createCustomSP(context: Context):CustomSP{
            sp= PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSP()
        }
    }

    fun saveToken(token:String){
        sp?.edit(commit = true){
            putString("token",token)
        }
    }

    fun getToken() = sp?.getString("token","asD")




}