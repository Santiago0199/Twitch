package com.santiagoperdomo.arquitecturamvp.http

import com.santiagoperdomo.arquitecturamvp.http.twitch.Game
import com.santiagoperdomo.arquitecturamvp.http.twitch.Streams
import com.santiagoperdomo.arquitecturamvp.http.twitch.Twitch
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TwitchAPI {

    @GET("games/top")
    fun getTopGames(@Header("Client-Id") clientId: String): Call<Twitch>

    @GET("games/top")
    fun getTopGamesObservable(@Header("Client-Id") clientId: String): Observable<Twitch>

    @GET("streams")
    fun getStramsObservable(@Header("Client-Id") clientId: String): Observable<Streams>

    @GET("games")
    fun getGameByStream(@Header("Client-Id") clientId: String, @Query("id") id: String): Observable<Twitch>

    /*@GET()
    fun getGameByName(@Header("Client-Id") clientId: String, @Query("name") name: String)*/

}