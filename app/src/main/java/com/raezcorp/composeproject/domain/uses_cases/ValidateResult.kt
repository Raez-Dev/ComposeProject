package com.raezcorp.composeproject.domain.uses_cases

data class ValidateResult(
    val successful:Boolean,
    val errorMessage:String? = null
)
