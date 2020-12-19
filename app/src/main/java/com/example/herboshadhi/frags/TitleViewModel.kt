package com.example.herboshadhi.frags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herboshadhi.PostModel
import com.example.herboshadhi.api.RetrofitBuilder.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

enum class PostsApiStatus { LOADING, ERROR, DONE }

class TitleViewModel:ViewModel() {

    private val _status = MutableLiveData<PostsApiStatus>()
    val status: LiveData<PostsApiStatus>
        get() = _status

    val onsucess=MutableLiveData<MutableList<PostModel>>()
    fun getposts(){
        viewModelScope.launch {
            _status.value=PostsApiStatus.LOADING
            val responce=apiService.posts()
            if (responce.isSuccessful) {
                _status.value=PostsApiStatus.DONE
            onsucess.postValue(responce.body())}
        }
    }
}

