package com.nextu.nextu_android_advanced.data.store

import com.nextu.nextu_android_advanced.model.ApiResponse
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Team
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeamsEndpoint {

    @GET("teams")
    suspend fun getAllTeams(
        @Query("league") leagueId: String = "61",
        @Query("season") season: String = "2023"
    ): ApiResponse

    @GET("teams")
    suspend fun getTeamById(@Query("id") id: String): ApiResponse


}