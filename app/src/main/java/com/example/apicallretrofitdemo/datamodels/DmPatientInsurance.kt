package com.example.apicallretrofitdemo.datamodels

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DmPatientInsurance(
    @Json(name ="id")
    var id: String? = "",

    @Json(name ="insurance_name")
    var insuranceName: String? = "",

    @Json(name ="insurance_no")
    var insuranceNo: String? = "",

    @Json(name ="relations")
    var relation: String? = "",

    @Json(name ="group_no")
    var groupNo: String? = "",

    @Json(name ="start_date")
    var startDate: String? = "",

    @Json(name ="end_date")
    var endDate: String? = "",

    @Json(name ="copay")
    var copay: String? = "",

    @Json(name ="priority")
    var priority: String? = "",

    @Json(name ="image_id")
    var imageId: String? = "",

    @Json(name ="case_type")
    var caseType: String? = "",

    @Json(name ="insurance_type")
    var insuranceType: String? = "",

    @Json(name ="case_id")
    var caseId: String? = "",

    @Json(name ="sr_id")
    var srId: String? = "",

    @Json(name ="insurance_id")
    var insuranceId: String? = "",

    @Json(name ="insured_by")
    var insuredBy: String? = "",

    @Json(name ="case_description")
    var caseDescription: String? = "",

    @Json(name ="case_start_date")
    var caseStartDate: String? = "",

    @Json(name ="pcp_info")
    var pcpInfo: String? = "",

    @Json(name ="injury_date")
    var injuryDate: String? = "",

    @Json(name ="captured_side")
    var capturedSide: String? = "",

    @Json(name ="is_notified")
    var isNotified: Boolean? = false


) : Parcelable {
    override fun toString(): String {
        return "DmPatientInsurance(insuranceName=$insuranceName, insuranceNo=$insuranceNo)"
    }
}
