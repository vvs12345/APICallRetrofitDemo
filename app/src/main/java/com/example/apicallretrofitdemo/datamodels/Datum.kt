package com.example.apicallretrofitdemo.datamodels

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import java.util.HashMap

@JsonClass(generateAdapter = true)
class Datum {
    @get:Json(name = "id")
    @set:Json(name = "id")
    @Json(name = "id")
    var id: Int? = null

    @get:Json(name = "email")
    @set:Json(name = "email")
    @Json(name = "email")
    var email: String? = null

    @get:Json(name = "first_name")
    @set:Json(name = "first_name")
    @Json(name = "first_name")
    var firstName: String? = null

    @get:Json(name = "last_name")
    @set:Json(name = "last_name")
    @Json(name = "last_name")
    var lastName: String? = null

    @get:Json(name = "avatar")
    @set:Json(name = "avatar")
    @Json(name = "avatar")
    var avatar: String? = null
    override fun toString(): String {
        return "Datum{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}'
    }
}