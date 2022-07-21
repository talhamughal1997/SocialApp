package com.example.gaditeksocialapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.main.FetchDataUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val fetchDataUC: FetchDataUC) : ViewModel() {

    fun fetchData(){
        viewModelScope.launch {
            val response =  fetchDataUC.invoke()
        }
    }
}