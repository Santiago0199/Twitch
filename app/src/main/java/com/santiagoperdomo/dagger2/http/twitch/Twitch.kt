package com.santiagoperdomo.dagger2.http.twitch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Twitch(game: List<Game>, pagination: Pagination) {

    @SerializedName("data")
    @Expose
    var game: List<Game>? = null
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null

    init {
        this.game = game
        this.pagination = pagination
    }
}