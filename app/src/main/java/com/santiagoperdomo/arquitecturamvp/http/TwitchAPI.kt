package com.santiagoperdomo.arquitecturamvp.http

import com.santiagoperdomo.arquitecturamvp.http.twitch.Twitch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TwitchAPI {

    @GET("games/top")
    fun getTopGames(@Header("Client-Id") clientId: String): Call<Twitch>

    /*@GET()
    fun getGameByName(@Header("Client-Id") clientId: String, @Query("name") name: String)*/

}