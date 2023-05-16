package com.raezcorp.composeproject.presentation.login

sealed class LoginFormEvents{
    data class EmailChange(val email:String) : LoginFormEvents()
    data class PasswordChange(val password:String) : LoginFormEvents()
    data class VisualTransformationChange(val visualTransformation: Boolean) : LoginFormEvents()
    object Submit : LoginFormEvents()

}
