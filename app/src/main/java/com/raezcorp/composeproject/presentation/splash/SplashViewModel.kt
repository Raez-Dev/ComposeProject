package com.raezcorp.composeproject.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raezcorp.composeproject.domain.uses_cases.UseCasesOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
    @Inject constructor(
        private val usesOnBoarding: UseCasesOnBoarding
    )
    :ViewModel() {
    private val _onBoardingComplete = MutableStateFlow(false)
    val onBoardingComplete : StateFlow<Boolean> = _onBoardingComplete

    init{
        viewModelScope.launch(Dispatchers.IO) {
            val completed = usesOnBoarding.readOnBoardingUseCase().stateIn(viewModelScope).value
            _onBoardingComplete.value = completed
        }
    }
}