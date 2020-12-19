package com.example.herboshadhi.frags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herboshadhi.PostModel
import com.example.herboshadhi.api.RetrofitBuilder
import kotlinx.coroutines.launch

class ContentViewModel:ViewModel() {
    private val _status = MutableLiveData<PostsApiStatus>()
    val status: LiveData<PostsApiStatus>
        get() = _status

    var iD=0

    val onsucc=MutableLiveData<PostModel>()

    fun getcont(){
        viewModelScope.launch {
            val responce= RetrofitBuilder.apiService.post_get_contents(iD)
            if(responce.isSuccessful){
                _status.value=PostsApiStatus.DONE
                onsucc.postValue(responce.body())
            }
        }
    }
}