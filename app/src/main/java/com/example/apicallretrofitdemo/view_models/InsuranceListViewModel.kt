package com.example.apicallretrofitdemo.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallretrofitdemo.repository.InsuranceRepository
import com.example.apicallretrofitdemo.utils.NetworkResponseState
import com.example.apicallretrofitdemo.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsuranceListViewModel @Inject constructor(private val insuranceRepository: InsuranceRepository) :
    ViewModel() {

    private val _insuranceList = MutableLiveData<String>()
    val insuranceList: LiveData<String> = _insuranceList

    private val _progressBarStatus = MutableLiveData<UIState>()
    val progressBarStatus: LiveData<UIState> = _progressBarStatus

    fun getInsuranceList() {
        setUIState(UIState.LOADING)
        viewModelScope.launch {

            when (val networkResponseState = insuranceRepository.getInsurances()) {
                is NetworkResponseState.Success -> {
                    _insuranceList.value = networkResponseState.result.data?.get(1)?.email
                    setUIState(UIState.SUCCESS)
                }
                is NetworkResponseState.Error -> {
                    setUIState(UIState.ERROR_SHOW)
                }
                is NetworkResponseState.Loading -> {
                    setUIState(UIState.LOADING)
                }
            }

//                is NetworkResponseState.Success -> {
//                    _insuranceList.value = networkResponseState.data
//            _insuranceList.value = networkResponseState.data[1].email
//                    setUIState(UIState.SUCCESS)
//                }
//                is NetworkResponseState.Error -> {
//                    setUIState(UIState.ERROR_SHOW)
//                }
//                is NetworkResponseState.OtherSuccess -> {
//                    setUIState(UIState.ERROR_SHOW)
//                }
//                is NetworkResponseState.TokenAuthFailed -> {
//                    setUIState(UIState.RE_LOGIN)
//                }
        }
    }

    private fun setUIState(uiState: UIState?) {
        _progressBarStatus.value=uiState
    }

}

