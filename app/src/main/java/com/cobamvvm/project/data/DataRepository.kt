package com.cobamvvm.project.data

import com.cobamvvm.project.data.api.ApiService
import com.cobamvvm.project.data.model.ConfirmedResponseItem

class DataRepository(private val apiDataRepository: ApiService
                     ) {

    suspend fun getConfirmedCase():List<ConfirmedResponseItem>{
        return apiDataRepository.getConfirmedCase().await()
    }

}