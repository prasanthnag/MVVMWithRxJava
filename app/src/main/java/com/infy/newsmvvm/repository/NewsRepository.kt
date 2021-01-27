package com.infy.newsmvvm.repository

import androidx.lifecycle.MutableLiveData
import com.infy.newsmvvm.api.ApiRepository
import com.infy.newsmvvm.api.RetrofitInstance
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.model.NewsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsRepository() {

    val newsLiveData: MutableLiveData<ArrayList<NewsDetails>> by lazy {
        callApi()
    }

    private fun callApi(): MutableLiveData<ArrayList<NewsDetails>> {

        val service = RetrofitInstance.getRetrofitInstance().create(ApiRepository::class.java)

        service.getNewsDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<NewsResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: NewsResponse) {
                    newsLiveData.postValue(t.newsDetails)
                }

                override fun onError(e: Throwable) {
                    newsLiveData.postValue(null)
                }
            })

        return MutableLiveData()
    }


}