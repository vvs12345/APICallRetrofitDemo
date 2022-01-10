package com.example.apicallretrofitdemo.datamodels

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
class Support {
    @get:Json(name = "url")
    @set:Json(name = "url")
    @Json(name = "url")
    var url: String? = null

    @get:Json(name = "text")
    @set:Json(name = "text")
    @Json(name = "text")
    var text: String? = null
}