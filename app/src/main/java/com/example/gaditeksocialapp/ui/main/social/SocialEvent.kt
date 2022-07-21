package com.example.gaditeksocialapp.ui.main.social

import com.example.domain.model.Social

sealed class SocialEvent{
    class OpenIntent(val social: Social) : SocialEvent()

}
