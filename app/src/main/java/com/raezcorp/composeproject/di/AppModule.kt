package com.raezcorp.composeproject.di

import android.content.Context
import com.raezcorp.composeproject.data.remote.Api
import com.raezcorp.composeproject.data.repository.DataStoreOperationsImpl
import com.raezcorp.composeproject.data.repository.UserRepositoryImp
import com.raezcorp.composeproject.domain.repository.DataStoreOperations
import com.raezcorp.composeproject.domain.repository.UserRepository
import com.raezcorp.composeproject.domain.uses_cases.UseCasesLogin
import com.raezcorp.composeproject.domain.uses_cases.UseCasesOnBoarding
import com.raezcorp.composeproject.domain.uses_cases.authenticate_user.AuthenticateUserUseCase
import com.raezcorp.composeproject.domain.uses_cases.read_boarding.ReadOnBoardingUseCase
import com.raezcorp.composeproject.domain.uses_cases.save_boarding.SaveOnBoardingUseCase
import com.raezcorp.composeproject.domain.uses_cases.validate_email.ValidateEmail
import com.raezcorp.composeproject.domain.uses_cases.validate_password.ValidatePassword
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi() : Api{
        //TODO Mover a gradle
        return Retrofit.Builder()
            .baseUrl("http://35.169.242.154:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context)
    }
    @Provides
    @Singleton
    fun provideUserRepository(api: Api) : UserRepository{
        return UserRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun provideUseCasesLogin(userRepository: UserRepository) : UseCasesLogin{
        return UseCasesLogin(
            validateEmail = ValidateEmail(),
            validatePassword = ValidatePassword(),
            authenticateUserUseCase = AuthenticateUserUseCase(userRepository)
        )
    }

    @Provides
    @Singleton
    fun provideUseCasesOnBoarding(repository: DataStoreOperations): UseCasesOnBoarding {
        return UseCasesOnBoarding(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
    }
}