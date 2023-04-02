package com.raezcorp.composeproject.presentation.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    //UI STATES ELEMENTS -> EMAIL, password (Ok)
    //SCREEN STATES -> isLoading, error, user (oK)
    //EVENTS (ok)
    //EMAIL CHANGE
    //PASSOWRD CHANGE
    //SUBMIT
    //VISUALTRANFORMATION

    fun onEvent(event:LoginFormEvents){
        when(event){
            is LoginFormEvents.EmailChange -> {

            }
            is LoginFormEvents.PasswordChange -> {

            }
            LoginFormEvents.Submit -> {
                SignIn()
            }
        }


    }

    fun SignIn(){



    }


}
