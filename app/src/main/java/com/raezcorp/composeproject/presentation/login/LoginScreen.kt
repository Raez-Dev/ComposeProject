package com.raezcorp.composeproject.presentation.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.raezcorp.composeproject.R
import com.raezcorp.composeproject.navigation.Screen
import com.raezcorp.composeproject.ui.theme.LigthColorMain
import com.raezcorp.composeproject.ui.theme.titleLoginColor

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val stateElements = loginViewModel.stateElements
    val state = loginViewModel.state

    val context = LocalContext.current


    /*var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }*/


    LaunchedEffect(key1 = state.user, key2 = state.error){

        if(state.user != null){
            Toast.makeText(context,"Bienvenido ${state.user?.names}",Toast.LENGTH_LONG).show()
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
        }
        if(state.error != null){
            Toast.makeText(context,state.error,Toast.LENGTH_LONG).show()
        }
        loginViewModel.resetStateUser()

    }

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.image_login),
                contentDescription = "Imagen Login",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.header_login),
                contentDescription = "Header Login",
                modifier = Modifier.size(200.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "Bienvenid@s",
                color = MaterialTheme.colors.titleLoginColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "Iniciar sesión",
                color = LigthColorMain,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = stateElements.email,
                onValueChange = {
                    loginViewModel.onEvent(LoginFormEvents.EmailChange(it))
                },
                label = {
                    Text(text = "Username")
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {

                    }
                ),
                isError = stateElements.emailError != null,
                singleLine = true,
            )

            if(stateElements.emailError != null){
                Text(text = stateElements.emailError!!,color= MaterialTheme.colors.error)
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = stateElements.password,
                onValueChange = {
                    loginViewModel.onEvent(LoginFormEvents.PasswordChange(it))
                },
                label = {
                    Text(text = "Password")
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {

                    }
                ),
                isError = stateElements.passwordError != null,
                singleLine = true,
                visualTransformation = if(stateElements.visualTransformation){
                    VisualTransformation.None
                }else{
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(onClick = { loginViewModel.onEvent(LoginFormEvents.VisualTransformationChange(!stateElements.visualTransformation)) }) {
                        Icon(
                            imageVector = if(stateElements.visualTransformation) Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = "Visibilty"
                        )
                    }
                }
            )

            if(stateElements.passwordError != null){
                Text(text = stateElements.passwordError!!,color= MaterialTheme.colors.error)
            }
            Button(
                onClick = {
                    loginViewModel.onEvent(LoginFormEvents.Submit)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = LigthColorMain,
                    contentColor = Color.White
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(50)

            ) {
                Text(text = "Ingresar", fontSize = 17.sp)
            }

            if(state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            /*if(state.user != null){
                Toast.makeText(context,"Bienvenido ${state.user?.names}",Toast.LENGTH_LONG).show()
            }
            if(state.error != null){
                Toast.makeText(context,state.error,Toast.LENGTH_LONG).show()
            }*/

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    append("Aun no te has registrado? ")
                    withStyle(
                        style = SpanStyle(
                            color = LigthColorMain
                        )
                    ) {
                        append("Registrarme")
                    }
                }
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = "Cambiar contraseña",
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center
            )
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navHostController = rememberNavController())
}
