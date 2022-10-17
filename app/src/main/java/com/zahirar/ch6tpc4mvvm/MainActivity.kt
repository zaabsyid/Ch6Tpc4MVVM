package com.zahirar.ch6tpc4mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zahirar.ch6tpc4mvvm.databinding.ActivityMainBinding
import com.zahirar.ch6tpc4mvvm.view.CarAdapter
import com.zahirar.ch6tpc4mvvm.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModelCar : ViewModelCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataCar()
    }

    fun showDataCar(){
        viewModelCar = ViewModelProvider(this).get(ViewModelCar::class.java)

        viewModelCar.getLDCar().observe(this, Observer {
            if (it != null){
                binding.rvListCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val adapter = CarAdapter(it)
                binding.rvListCar.adapter = adapter
            }
        })
        viewModelCar.callApiCar()
    }
}