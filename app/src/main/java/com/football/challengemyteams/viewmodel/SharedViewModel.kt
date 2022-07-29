package com.football.challengemyteams.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.football.challengemyteams.api.ApiService
import com.football.challengemyteams.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
@Inject
constructor(private val repository: ApiRepository,    private val apiService: ApiService
) : ViewModel() {

    val sportId = MutableLiveData<String>("0")
    val countryId = MutableLiveData<String>("0")
    val nickName = MutableLiveData<String>("NickName")
    val uri = MutableLiveData<String>("")

}
