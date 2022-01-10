package com.example.apicallretrofitdemo.api


import com.example.apicallretrofitdemo.datamodels.Example
import retrofit2.Response
import retrofit2.http.GET

interface InsuranceService {

    @GET("api/users")
    suspend fun getPatientInsurances(): Response<Example>

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