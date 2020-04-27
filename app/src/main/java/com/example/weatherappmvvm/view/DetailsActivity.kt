package com.example.weatherappmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappmvvm.R
import com.example.weatherappmvvm.viewmodel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel : DetailsActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel = ViewModelProvider(this).get(DetailsActivityViewModel::class.java)

        if(intent.hasExtra("name")){
            tv_location.text = intent.getStringExtra("name")
        }

        if(intent.hasExtra("Location")){
            val location = intent.getIntExtra("Location",0)
            if(location > 0)
            viewModel.getWeather(location)
        }

        viewModel.showProgress.observe(this, Observer {
            if(it)
                details_progress.visibility = VISIBLE
            else
                details_progress.visibility = GONE
        })

        viewModel.response.observe(this, Observer {
            if(it != null)
                tv_temp.text = it.consolidatedWeather[0].theTemp.toString()
        })
    }
}
