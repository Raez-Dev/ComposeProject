package com.raezcorp.composeproject.domain.repository

import com.raezcorp.composeproject.domain.model.User
import com.raezcorp.composeproject.core.Result
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun authenticateUser(email:String,password:String) : Flow<Result<User>>

}
