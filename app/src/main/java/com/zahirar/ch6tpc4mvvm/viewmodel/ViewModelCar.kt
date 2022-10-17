package com.zahirar.ch6tpc4mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zahirar.ch6tpc4mvvm.model.GetCarResponseItem
import com.zahirar.ch6tpc4mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel(){
    lateinit var liveDataCar : MutableLiveData<List<GetCarResponseItem>>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getLDCar() : MutableLiveData<List<GetCarResponseItem>> {
        return liveDataCar
    }

    fun callApiCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetCarResponseItem>>,
                    response: Response<List<GetCarResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    } else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetCarResponseItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })
    }
}