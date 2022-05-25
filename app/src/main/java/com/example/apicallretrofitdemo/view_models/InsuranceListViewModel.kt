package com.example.apicallretrofitdemo.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListRequest
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListResponse
import com.example.apicallretrofitdemo.datamodels.ResponseObject
import com.example.apicallretrofitdemo.repository.InsuranceRepository
import com.example.apicallretrofitdemo.utils.CommentApiState
import com.example.apicallretrofitdemo.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsuranceListViewModel @Inject constructor(private val insuranceRepository: InsuranceRepository) :
    ViewModel() {

    val commentState = MutableStateFlow(
        CommentApiState(
            Status.LOADING,
            ResponseObject<DmInsuranceListResponse>(), ""
        )
    )

    fun getInsuranceList(dmInsuranceListRequest: DmInsuranceListRequest) {
        viewModelScope.launch {
            insuranceRepository.getInsurances(dmInsuranceListRequest).catch {
                commentState.value =
                    CommentApiState.error(it.message.toString())
            }.collect {
                commentState.value = CommentApiState.success(it.data)
            }
        }
    }
}

