package com.raezcorp.composeproject.presentation.login

import com.raezcorp.composeproject.domain.model.User

data class LoginState(
    val isLoading: Boolean = false,
    val error:String? = null,
    //TODO Modify to User
    val user: User? = null
)
