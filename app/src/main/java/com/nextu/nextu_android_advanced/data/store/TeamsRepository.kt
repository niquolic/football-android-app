package com.nextu.nextu_android_advanced.data.store

import android.util.Log
import com.nextu.nextu_android_advanced.model.Category
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Team


class TeamsRepository(private val endpoint: TeamsEndpoint) {

    companion object {
        const val TAG = "TeamsRepository"
    }

    suspend fun getAllTeams(): List<Team> {
        return try {
            val response = endpoint.getAllTeams()
            response.response
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            listOf()
        }
    }

    suspend fun getTeamById(id: String): List<Team>? {
        return try {
            val response = endpoint.getTeamById(id)
            response.response
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            null
        }
    }
}