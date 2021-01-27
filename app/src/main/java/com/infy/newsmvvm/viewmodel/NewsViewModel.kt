package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.api.ApiRepository
import com.infy.newsmvvm.api.RetrofitInstance
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.model.NewsResponse
import com.infy.newsmvvm.repository.NewsRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    //var newsDetailsLiveData: MutableLiveData<ArrayList<NewsDetails>> = MutableLiveData()

    val newsDetailsLiveData by lazy {
        newsRepository.newsLiveData
    }

    /*init {
        callApi()
    }

    private fun callApi() {
        val service = RetrofitInstance.getRetrofitInstance().create(ApiRepository::class.java)

        service.getNewsDetails().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getNewsDetailsFromApi())
    }

    private fun getNewsDetailsFromApi(): Observer<NewsResponse> {
        return object : Observer<NewsResponse> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: NewsResponse) {
                newsDetailsLiveData.postValue(t.newsDetails)
            }

            override fun onError(e: Throwable) {
                newsDetailsLiveData.postValue(null)
            }
        }
    }*/

}