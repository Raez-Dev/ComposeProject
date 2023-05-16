package com.raezcorp.composeproject.data.model

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data:UserDto,
    @SerializedName("token")
    val token:String
)

data class UserDto(
    @SerializedName("uuid")
    val uuid:String,
    @SerializedName("nombres")
    val names:String,
    @SerializedName("apellidos")
    val lastName:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("celular")
    val phone:String,
    @SerializedName("genero")
    val gender:String,
    @SerializedName("nroDoc")
    val numberDoc:String,
    @SerializedName("tipo")
    val type:String
)
