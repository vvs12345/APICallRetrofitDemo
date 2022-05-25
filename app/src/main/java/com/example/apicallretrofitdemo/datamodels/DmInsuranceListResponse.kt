package com.example.apicallretrofitdemo.datamodels

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DmInsuranceListResponse(
    @Json(name = "patient_insurance")

    var patientInsurances: List<DmPatientInsurance>? = arrayListOf(),
    @Json(name = "case_insurance")
    val caseInsurances: List<DmPatientInsurance>? = arrayListOf(),
): Parcelable
