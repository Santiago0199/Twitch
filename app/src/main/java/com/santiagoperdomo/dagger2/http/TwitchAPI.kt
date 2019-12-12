package com.santiagoperdomo.dagger2.http

import com.santiagoperdomo.dagger2.http.twitch.Twitch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TwitchAPI {

    @GET("games/top")
    fun getTopGames(@Header("Client-Id") clientId: String): Call<Twitch>

    /*@GET()
    fun getGameByName(@Header("Client-Id") clientId: String, @Query("name") name: String)*/

}