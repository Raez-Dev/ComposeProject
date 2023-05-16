package com.raezcorp.composeproject.data.repository


import android.util.Log
import com.raezcorp.composeproject.core.Result
import com.raezcorp.composeproject.data.model.LoginRequest
import com.raezcorp.composeproject.data.remote.Api
import com.raezcorp.composeproject.domain.model.User
import com.raezcorp.composeproject.domain.model.toUser
import com.raezcorp.composeproject.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(private val api: Api) : UserRepository {
    override suspend fun authenticateUser(email: String, password: String): Flow<Result<User>> =
        flow {
            try {
                emit(Result.Loading())
                val loginDto = api.authenticate(LoginRequest(email, password)).body()
                if (loginDto?.success == true) {
                    emit(Result.Success(data = loginDto.data.toUser()))
                } else {
                    //Validacion de acceso incorrecta
                    emit(Result.Error(message = loginDto?.message!!))
                }
            } catch (ex: HttpException) {
                emit(Result.Error(message = "Encontramos un error en su solicitud."))
            } catch (ex: IOException) {
                ex.message?.let { Log.d("TRACE", it) }
                emit(Result.Error(message = "No se pudo conectar al servidor, revise su conexion."))
            }
        }

}

