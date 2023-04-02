package com.raezcorp.composeproject.presentation.login

sealed class LoginFormEvents{
    data class EmailChange(val email:String) : LoginFormEvents()
    data class PasswordChange(val password:String) : LoginFormEvents()
    object Submit : LoginFormEvents()

}
