package com.league2022of.proball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.league2022of.proball.api.ApiService
import com.league2022of.proball.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject
constructor(private val repository: ApiRepository,    private val apiService: ApiService
) : ViewModel() {

    val sportId = MutableLiveData<String>("0")
    val roster = MutableLiveData<Int>(0)
    val countryId = MutableLiveData<String>("0")
    val nickName = MutableLiveData<String>("NickName")
    val uri = MutableLiveData<String>("")

}
