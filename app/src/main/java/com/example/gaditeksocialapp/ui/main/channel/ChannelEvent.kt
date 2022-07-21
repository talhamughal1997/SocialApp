package com.example.gaditeksocialapp.ui.main.channel

import com.example.domain.model.Channel

sealed class ChannelEvent{
    class OpenIntent(val channel: Channel) : ChannelEvent()

}
