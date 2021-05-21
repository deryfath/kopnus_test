package com.cobamvvm.project.data.api

import com.cobamvvm.project.data.model.ConfirmedResponseItem
import retrofit2.http.GET
import kotlinx.coroutines.Deferred


interface ApiService {

    @GET("/api/confirmed")
    fun getConfirmedCase():Deferred<List<ConfirmedResponseItem>>
}