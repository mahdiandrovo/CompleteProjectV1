package com.drovo.completeproject.repository

import com.drovo.completeproject.models.Post
import com.drovo.completeproject.network.ApiServiceImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiServiceImplementation: ApiServiceImplementation
) {
    //Flow
    //data k asynchronously server theke fetch kore
    //then one by one provide kore or emit kore
    fun getPost(): Flow<List<Post>> = flow {
        emit(apiServiceImplementation.getPost())
    }.flowOn(Dispatchers.IO)
}