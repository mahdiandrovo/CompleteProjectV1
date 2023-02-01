package com.drovo.completeproject.network

import com.drovo.completeproject.models.Post
import javax.inject.Inject

class ApiServiceImplementation @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPost(): List<Post> = apiService.getPost()
}