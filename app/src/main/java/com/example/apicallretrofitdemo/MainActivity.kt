package com.example.apicallretrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.apicallretrofitdemo.databinding.ActivityMainBinding
import com.example.apicallretrofitdemo.datamodels.DmInsuranceListRequest
import com.example.apicallretrofitdemo.utils.Status
import com.example.apicallretrofitdemo.view_models.InsuranceListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: InsuranceListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dmInsuranceListRequest = DmInsuranceListRequest().apply {
            patientId = "1"
            command = "GET_PATIENT_INSURANCE"
            deviceId = "38ef00ede98a45d7"
            machineName = "38ef00ede98a45d7"
            token = "1q2w3e4r5t6y"
            userId = "129"
            userName = "GBazo"
        }
        viewModel.getInsuranceList(dmInsuranceListRequest)

        viewModel.response.observe(this) {
            binding.progressBar.isVisible = false
            Log.e("QQQQQQQQQQQQQQQQQ", "" + it.patientInsurances.toString())
        }

        viewModel.errorMessage.observe(this) {
            binding.progressBar.isVisible = false
            Log.e("QQQQQQQQQQQQQQQQQ", "" + it)
        }
    }
}