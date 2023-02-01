package com.drovo.completeproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drovo.completeproject.repository.MainRepository
import com.drovo.completeproject.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _postStateFlow: StateFlow<ApiState> = postStateFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading

        //data fetch korar shomoy kichu error ashte pare
        //tai .catch{} block ana hoise
        //ekhane e te message ta ase tai pass kore dea hoise ApiState.Failure(e)

        //.collect{} mane successfull hoise
        //no error
        mainRepository.getPost()
            .catch { e->
                postStateFlow.value = ApiState.Failure(e)
            }.collect{ data->
                postStateFlow.value = ApiState.Success(data)
            }

    }

}