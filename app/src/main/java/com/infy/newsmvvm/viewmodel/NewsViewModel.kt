package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.repository.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val newsDetailsLiveData by lazy {
        newsRepository.newsLiveData
    }

}