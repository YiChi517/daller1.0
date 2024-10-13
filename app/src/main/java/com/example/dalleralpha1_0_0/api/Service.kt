package com.example.dalleralpha1_0_0.api

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


    private const val url="http://192.168.31.221:9674/v1/"
    private val okHttp=OkHttpClient.Builder()

    interface LoginService{
//        @Header("Content-type:application/json")
        @POST("users/login")
        fun login(@Body LoginRequest:LoginRequest): Call<LoginResponse>
    }

    object Api{
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(okHttp.build())
            .build()
        val retrofitService: LoginService = retrofit.create(LoginService::class.java)
    }

