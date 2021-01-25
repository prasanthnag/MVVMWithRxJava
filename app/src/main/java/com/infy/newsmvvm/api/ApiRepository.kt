package com.infy.newsmvvm.api

import android.database.Observable
import com.infy.newsmvvm.model.NewsDetails
import retrofit2.http.GET

interface ApiRepository {

    @GET("facts.json")
    fun getFacts() : Observable<NewsDetails>
}