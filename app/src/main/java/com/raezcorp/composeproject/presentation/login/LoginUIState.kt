package com.raezcorp.composeproject.presentation.login

data class LoginUIState(
    val email:String = "",
    val emailError:String? = null,
    val password:String = "",
    val passwordError:String? = null
)
