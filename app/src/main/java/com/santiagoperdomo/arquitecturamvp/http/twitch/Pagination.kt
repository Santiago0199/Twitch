package com.santiagoperdomo.arquitecturamvp.http.twitch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pagination(cursor: String) {

    @SerializedName("cursor")
    @Expose
    var cursor: String? = null

    init {
        this.cursor = cursor
    }
}