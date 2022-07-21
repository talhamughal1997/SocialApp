package com.example.gaditeksocialapp.ui.main.social

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Channel
import com.example.domain.model.Social
import com.example.domain.usecase.main.social_list.GetSocialListUC
import com.example.gaditeksocialapp.ui.main.channel.ChannelEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SocialListViewModel @Inject constructor(private val getSocialListUC: GetSocialListUC) :
    ViewModel() {

    private val event = MutableLiveData<SocialEvent>()
    val _event: LiveData<SocialEvent> = event

    val socialList by lazy {
        getSocialListUC()
    }


    fun openIntent(social: Social){
        event.value = SocialEvent.OpenIntent(social)
    }

}