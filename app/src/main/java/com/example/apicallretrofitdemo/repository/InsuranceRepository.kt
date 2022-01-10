package com.example.apicallretrofitdemo.repository

import com.example.apicallretrofitdemo.api.InsuranceService
import com.example.apicallretrofitdemo.datamodels.Example
import com.example.apicallretrofitdemo.utils.NetworkResponseState
import com.example.apicallretrofitdemo.utils.safeApiCall
import retrofit2.Response
import javax.inject.Inject

class InsuranceRepository @Inject constructor(private val insuranceService: InsuranceService) {
    suspend fun getInsurances(): NetworkResponseState<Example> =
        safeApiCall { insuranceService.getPatientInsurances() }

}