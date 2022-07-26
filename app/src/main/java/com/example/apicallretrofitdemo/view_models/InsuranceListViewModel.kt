package com.example.apicallretrofitdemo.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListRequest
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListResponse
import com.example.apicallretrofitdemo.repository.InsuranceRepository
import com.example.apicallretrofitdemo.utils.CommentApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsuranceListViewModel @Inject constructor(private val insuranceRepository: InsuranceRepository) :
    ViewModel() {



    private val _response: MutableLiveData<DmInsuranceListResponse> = MutableLiveData()
    val response: LiveData<DmInsuranceListResponse> = _response

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    fun getInsuranceList(dmInsuranceListRequest: DmInsuranceListRequest) {
        viewModelScope.launch {
            val networkResponseState = insuranceRepository.getInsurances(dmInsuranceListRequest)
            networkResponseState
                .collect {
                when (it) {
                    is CommentApiState.Success -> {
                        _response.value=it.data
                    }
                    is CommentApiState.Error -> {
                        _errorMessage.value = it.description
                    }
                    is CommentApiState.OtherSuccess -> {

                    }
                    is CommentApiState.TokenAuthFailed -> {
                        _errorMessage.value = it.description
                    }
                }
            }
        }
    }
}

