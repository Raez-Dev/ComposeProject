package com.raezcorp.composeproject.presentation.login

data class LoginUIState(
    val email:String = "jledesma2509@gmail.com",
    val emailError:String? = null,
    val password:String = "12345",
    val passwordError:String? = null,
    val visualTransformation: Boolean = false

)
