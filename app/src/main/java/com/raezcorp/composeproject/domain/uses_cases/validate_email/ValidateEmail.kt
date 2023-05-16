package com.raezcorp.composeproject.domain.uses_cases.validate_email

import android.util.Patterns
import com.raezcorp.composeproject.domain.uses_cases.ValidateResult

class ValidateEmail {

    operator fun invoke(email:String) : ValidateResult{

        if(email.isBlank()){
            return ValidateResult(
                successful = false,
                errorMessage = "Su email no puede estar en blanco"
            )
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidateResult(
                successful = false,
                errorMessage = "Su email no tiene el formato correcto"
            )
        }

        return ValidateResult(
            successful = true
        )



    }

}
