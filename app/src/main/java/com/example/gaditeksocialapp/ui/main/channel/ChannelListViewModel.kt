package com.example.gaditeksocialapp.ui.main.channel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Channel
import com.example.domain.model.Social
import com.example.domain.usecase.main.channel_list.GetChannelListUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ChannelListViewModel @Inject constructor(private val getChannelListUC: GetChannelListUC) :
    ViewModel() {

    private val event = MutableLiveData<ChannelEvent>()
    val _event: LiveData<ChannelEvent> = event

    val channelList by lazy {
        getChannelListUC()
    }

    fun openIntent(channel: Channel){
        event.value = ChannelEvent.OpenIntent(channel)
    }
}