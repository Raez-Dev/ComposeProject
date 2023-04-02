package com.raezcorp.composeproject.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raezcorp.composeproject.domain.uses_cases.UseCasesOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel
@Inject constructor(
    private val useCasesOnBoarding: UseCasesOnBoarding
) : ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            useCasesOnBoarding.saveOnBoardingUseCase(completed = completed)
        }
    }


}