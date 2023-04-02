package com.raezcorp.composeproject.presentation.login

data class LoginState(
    val isLoading: Boolean = false,
    val error:String? = null,
    //TODO Modify to User
    val user:Unit? = null
)
