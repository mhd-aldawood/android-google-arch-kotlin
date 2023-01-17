package com.example.medicusai.network

import com.example.medicusai.model.Biomarker
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET("hZZ5j8/biomarkers")
    fun getAllBiomarker():Observable<List<Biomarker>>
}