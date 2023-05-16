package com.raezcorp.composeproject.domain.model

import com.raezcorp.composeproject.data.model.UserDto

data class User(
    val uuid:String,
    val names:String,
    val lastName:String,
    val email:String,
    val phone:String,
    val gender:String,
    val numberDoc:String,
    val type:String
)

//UserDto -> User
//Extensions Functions
fun UserDto.toUser() : User{
    return User(
        uuid = uuid,
        names = names,
        lastName = lastName,
        email = email,
        phone = phone,
        gender = gender,
        numberDoc = numberDoc,
        type = type
    )
}
