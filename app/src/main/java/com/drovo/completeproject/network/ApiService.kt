package com.drovo.completeproject.network

import com.drovo.completeproject.models.Post
import retrofit2.http.GET

interface ApiService {
    //get holo retrofit er annotation
    //get shudhu end point tar perameter e nibe
    //niche ekta function create korte hoy jetar return type dite hoy
    //ei return type er data e pass hoie ashe
    //ekhane Post type list data ashbe
    //tai return type List<Post>
    //Post holo data class ba Model class
    //function type is supand so that it will run in background
    @GET("/posts")
    suspend fun getPost(): List<Post>
}