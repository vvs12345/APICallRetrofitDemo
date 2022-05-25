package com.example.apicallretrofitdemo.api


import com.example.apicallretrofitdemo.datamodels.DmInsuranceListRequest
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListResponse
import com.example.apicallretrofitdemo.datamodels.ResponseObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface InsuranceService {

    @POST("apps.php")
    suspend fun getPatientInsurances(@Body dmInsuranceListRequest: DmInsuranceListRequest): ResponseObject<DmInsuranceListResponse>

//    @Multipart
//    @POST("api/insurance/uploadInsurance")
//    suspend fun savePhotos(
//        @PartMap partMap: MutableMap<String, RequestBody>,
//        @Part frontImage: MultipartBody.Part?
//    ): ResponseObject<Any>
//
//    @Streaming
//    @GET("api/insurance/insuranceImage")
//    suspend fun getPhotos(
//        @Query("patient_id") patientId: String,
//        @Query("image_id") imageId: String
//    ): Response<ResponseBody>

}