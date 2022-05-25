package com.example.apicallretrofitdemo.datamodels

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DmInsuranceListRequest(
    @field:Json(name = "patient_id")
    var patient_id: String = "",
    @field:Json(name ="COMMAND")
    var COMMAND: String? = null,

    @field:Json(name ="device_id") var device_id: String? = null,

    @field:Json(name ="machine_name") var machine_name: String? = null,

    @field:Json(name ="token") var token: String? = null,

    @field:Json(name ="user_id")
    var user_id: String? = null,

    @field:Json(name ="username")
    var username: String? = null,
) : Parcelable
