package com.example.apicallretrofitdemo.datamodels

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class DmInsuranceListRequest(
    @field:Json(name = "patient_id")
    var patientId: String = "",
    @field:Json(name ="COMMAND")
    var command: String? = null,

    @field:Json(name ="device_id") var deviceId: String? = null,

    @field:Json(name ="machine_name") var machineName: String? = null,

    @field:Json(name ="token") var token: String? = null,

    @field:Json(name ="user_id")
    var userId: String? = null,

    @field:Json(name ="username")
    var userName: String? = null,
) : Parcelable
