package com.raezcorp.composeproject.domain.uses_cases

import com.raezcorp.composeproject.domain.uses_cases.authenticate_user.AuthenticateUserUseCase
import com.raezcorp.composeproject.domain.uses_cases.validate_email.ValidateEmail
import com.raezcorp.composeproject.domain.uses_cases.validate_password.ValidatePassword

data class UseCasesLogin(
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword,
    val authenticateUserUseCase: AuthenticateUserUseCase
)
