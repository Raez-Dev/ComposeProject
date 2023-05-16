package com.raezcorp.composeproject.domain.uses_cases.authenticate_user

import com.raezcorp.composeproject.domain.repository.UserRepository
import javax.inject.Inject

class AuthenticateUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(email:String,password:String) = userRepository.authenticateUser(email,password)

}
