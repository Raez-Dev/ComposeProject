package com.raezcorp.composeproject.domain.uses_cases

import com.raezcorp.composeproject.domain.uses_cases.read_boarding.ReadOnBoardingUseCase
import com.raezcorp.composeproject.domain.uses_cases.save_boarding.SaveOnBoardingUseCase

data class UseCasesOnBoarding(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)