package com.example.apicallretrofitdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apicallretrofitdemo.databinding.ActivityMainBinding
import com.example.apicallretrofitdemo.utils.UIState
import com.example.apicallretrofitdemo.view_models.InsuranceListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: InsuranceListViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//
//        val dmInsuranceListRequest= DmInsuranceListRequest().apply {
//            patientId="1"
//            strCommand="GET_PATIENT_INSURANCE"
//            strDeviceId="38ef00ede98a45d7"
//            strMachineName="38ef00ede98a45d7"
//            strToken="3e14eae13dd52f19928f803e80d55803"
//            strUserId="129"
//            strUsername="GBazo"
//        }
        viewModel.getInsuranceList()

        viewModel.progressBarStatus.observe(this,{
            when(it){
                UIState.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })

        viewModel.insuranceList.observe(this,{
            Log.e("EEEEEEEEEEEEEEEEEEEE",""+it)
        })
    }
}