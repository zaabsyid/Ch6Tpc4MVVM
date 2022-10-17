package com.zahirar.ch6tpc4mvvm.network

import com.zahirar.ch6tpc4mvvm.model.GetCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<GetCarResponseItem>>
}