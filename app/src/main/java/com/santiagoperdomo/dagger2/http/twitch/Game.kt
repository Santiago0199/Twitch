package com.santiagoperdomo.dagger2.http.twitch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Game(id: String, name: String, boxArtUrl: String) {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("box_art_url")
    @Expose
    var boxArtUrl: String? = null

    init {
        this.id = id
        this.name = name
        this.boxArtUrl = boxArtUrl
    }

}