package com.raezcorp.composeproject.data.model

data class LoginRequest(
    val email:String,
    val password:String,
    val firebaseToken:String=""
)
