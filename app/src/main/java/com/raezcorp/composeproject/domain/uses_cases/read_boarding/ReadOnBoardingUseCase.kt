package com.raezcorp.composeproject.domain.uses_cases.read_boarding

import com.raezcorp.composeproject.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: DataStoreOperations) {

    operator fun invoke() : Flow<Boolean> {
        return repository.readOnBoardingState()
    }

}