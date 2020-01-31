package com.santiagoperdomo.arquitecturamvp.http.twitch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Streams(data: List<Datum>?, pagination: Pagination?) {

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null

    init {
        this.data = data
        this.pagination = pagination
    }
}