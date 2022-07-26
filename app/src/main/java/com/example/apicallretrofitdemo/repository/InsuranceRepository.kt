package com.example.apicallretrofitdemo.repository

import com.example.apicallretrofitdemo.api.InsuranceService
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListRequest
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListResponse
import com.example.apicallretrofitdemo.datamodels.ResponseObject
import com.example.apicallretrofitdemo.utils.CommentApiState
import com.example.apicallretrofitdemo.utils.executeCoroutine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class InsuranceRepository @Inject constructor(private val insuranceService: InsuranceService) {

    suspend fun getInsurances(dmInsuranceListRequest: DmInsuranceListRequest): Flow<CommentApiState<DmInsuranceListResponse>> {
        return flow {
            emit(executeCoroutine {  insuranceService.getPatientInsurances(dmInsuranceListRequest) })
        }.flowOn(Dispatchers.IO)
    }

}