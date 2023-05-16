package com.raezcorp.composeproject.domain.uses_cases.validate_password

import com.raezcorp.composeproject.domain.uses_cases.ValidateResult


class ValidatePassword {

    operator fun invoke(password:String) : ValidateResult {

        if(password.isBlank()){
            return ValidateResult(
                successful = false,
                errorMessage = "Su password no puede estar en blanco"
            )
        }


        return ValidateResult(
            successful = true
        )



    }
}
