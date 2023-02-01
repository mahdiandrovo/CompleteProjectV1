package com.drovo.completeproject.util

import com.drovo.completeproject.models.Post

sealed class ApiState{
    //application er joto state ase ta ekhane introduce kora hbe
    //control ba manage kora hbe na
    //viewmodel e manage kora hobe
    //loading
    //success
    //fail etc...

    //parameter na lagle object nite hbe
    object Loading: ApiState()

    //parameter lagle class
    class Failure(val msg: Throwable): ApiState()
    class Success(val data: List<Post>): ApiState()

    //ekhane by default kichu value dite hoy
    //tai ei empty create kora hocche
    //private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    //etr jonno MutableStateFlow(ApiState.Empty)
    object Empty: ApiState()

}
