package com.raezcorp.composeproject.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.raezcorp.composeproject.domain.uses_cases.UseCasesLogin
import com.raezcorp.composeproject.core.Result

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject
constructor(
    private val usesCasesLogin : UseCasesLogin
) : ViewModel() {
    //UI STATES ELEMENTS ->
    // EMAIL, password (Ok)

    //SCREEN STATES -> isLoading, error, success(user)

    //EVENTS (ok)
    //EMAIL CHANGE
    //PASSOWRD CHANGE
    //SUBMIT
    //VISUALTRANFORMATION

    var stateElements by mutableStateOf(LoginUIState())
    var state by mutableStateOf(LoginState())

    fun onEvent(event: LoginFormEvents) {

        when (event) {
            is LoginFormEvents.EmailChange -> {
                stateElements = stateElements.copy(email = event.email)
            }
            is LoginFormEvents.PasswordChange -> {
                stateElements = stateElements.copy(password = event.password)
            }
            is LoginFormEvents.VisualTransformationChange -> {
                stateElements = stateElements.copy(visualTransformation = event.visualTransformation)
            }
            LoginFormEvents.Submit -> {
                SignIn()
            }

        }

    }

    private fun SignIn() {

        val emailResult = usesCasesLogin.validateEmail(stateElements.email)
        val passwordResult = usesCasesLogin.validatePassword(stateElements.password)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any{
            !it.successful
        }

        if(hasError){
            stateElements = stateElements.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }else{
            stateElements = stateElements.copy(
                emailError = null,
                passwordError = null
            )
        }

        viewModelScope.launch {
            usesCasesLogin.authenticateUserUseCase(stateElements.email,stateElements.password).catch {

            }.onEach { result ->
                when(result){
                    is Result.Error -> {
                        state = state.copy(error = result.message)
                        state = state.copy(isLoading = false)
                    }
                    is Result.Loading -> {
                        state = state.copy(isLoading = true)
                    }
                    is Result.Success -> {
                        state = state.copy(user = result.data)
                        state = state.copy(isLoading = false)
                    }
                    else -> {}
                }
            }.launchIn(viewModelScope)
        }

    }

    fun resetStateUser() {
        state = state.copy(user = null, error = null)
    }

}
