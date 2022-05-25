package com.example.apicallretrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
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

    private val viewModel: InsuranceListViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//
        val dmInsuranceListRequest= DmInsuranceListRequest().apply {
            patient_id="1"
            COMMAND="GET_PATIENT_INSURANCE"
            device_id="38ef00ede98a45d7"
            machine_name="38ef00ede98a45d7"
            token="1446c9ecefe63b6a219b4e9bb14a6dee"
            user_id="129"
            username="GBazo"
        }
        viewModel.getInsuranceList(dmInsuranceListRequest)

        lifecycleScope.launch {

            viewModel.commentState.collect {

                // When state to check the
                // state of received data
                when (it.status) {

                    // If its loading state then
                    // show the progress bar
                    Status.LOADING -> {
                        binding.progressBar.isVisible = true
                    }
                    // If api call was a success , Update the Ui with
                    // data and make progress bar invisible
                    Status.SUCCESS -> {
                        binding.progressBar.isVisible = false

                        // Received data can be null, put a check to prevent
                        // null pointer exception
                        it.data?.let { comment ->
                            Log.e("QQQQQQQQQQQQQQQQQ",""+ comment.data.patientInsurances.toString())
                        }
                    }
                    // In case of error, show some data to user
                    else -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}