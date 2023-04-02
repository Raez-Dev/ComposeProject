package com.raezcorp.composeproject.domain.uses_cases.save_boarding

import com.raezcorp.composeproject.domain.repository.DataStoreOperations

class SaveOnBoardingUseCase(private val repository: DataStoreOperations) {

    //suspend fun execute(completed:Boolean){
    suspend operator fun invoke(completed:Boolean){
        repository.saveOnBoardingState(completed = completed)
    }

}