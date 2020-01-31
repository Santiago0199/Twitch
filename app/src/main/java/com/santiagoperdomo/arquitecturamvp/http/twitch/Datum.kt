package com.santiagoperdomo.arquitecturamvp.http.twitch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum(id: String, userId: String, userName: String, gameId: String, type: String, title: String, viewerCount: Int?, startedAt: String, language: String, thumbnailUrl: String) {

    @SerializedName("id")
    @Expose
    val id: String
    @SerializedName("user_id")
    @Expose
    val userId: String
    @SerializedName("user_name")
    @Expose
    val userName: String
    @SerializedName("game_id")
    @Expose
    val gameId: String
    @SerializedName("type")
    @Expose
    val type: String
    @SerializedName("title")
    @Expose
    val title: String
    @SerializedName("viewer_count")
    @Expose
    val viewerCount: Int?
    @SerializedName("started_at")
    @Expose
    val startedAt: String
    @SerializedName("language")
    @Expose
    val language: String
    @SerializedName("thumbnail_url")
    @Expose
    val thumbnailUrl: String

    init {
        this.id = id
        this.userId = userId
        this.userName = userName
        this.gameId = gameId
        this.type = type
        this.title = title
        this.viewerCount = viewerCount
        this.startedAt = startedAt
        this.language = language
        this.thumbnailUrl = thumbnailUrl
    }

}