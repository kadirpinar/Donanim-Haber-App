package com.example.dh.network

import com.example.dh.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/dev/and/api/newest?pageSize=15")
   fun  getNews(@Query("pageIndex") page:Int): Call<ResponseModel>

}