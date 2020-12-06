package com.example.herboshadhi

import com.google.gson.annotations.SerializedName

class PostModel {
    var id = 0
    var title:Title?=null
    var content: Content? = null
    var _embedded:embedded?=null
}

class Title{
    var rendered:String? = null
}

class Content{
    var rendered:String? = null
    var protected:Boolean = false
}

class embedded{
    @SerializedName("wp:featuredmedia")
    var featuremedia: List<Featuremedia>? =null
}

class Featuremedia{
    var source_url:String?=null
}