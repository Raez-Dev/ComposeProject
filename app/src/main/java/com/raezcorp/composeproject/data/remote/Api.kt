package com.raezcorp.composeproject.data.remote

import com.raezcorp.composeproject.data.model.LoginDto
import com.raezcorp.composeproject.data.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    //http://35.169.242.154:3000/api/usuarios/login
    @POST("api/usuarios/login")
    suspend fun authenticate(@Body request: LoginRequest) : Response<LoginDto>

}
