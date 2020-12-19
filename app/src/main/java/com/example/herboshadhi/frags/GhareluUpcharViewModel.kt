package com.example.herboshadhi.frags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herboshadhi.PostModel
import com.example.herboshadhi.api.RetrofitBuilder
import kotlinx.coroutines.launch

class GhareluUpcharViewModel:ViewModel() {

    private val _status = MutableLiveData<PostsApiStatus>()
    val status: LiveData<PostsApiStatus>
        get() = _status

    val onsucess= MutableLiveData<MutableList<PostModel>>()
    fun getposts(){
        viewModelScope.launch {
            val responce= RetrofitBuilder.apiService.posts_gharelu_upchar()
            if (responce.isSuccessful) {
                _status.value=PostsApiStatus.DONE
                onsucess.postValue(responce.body())}
        }
    }

}