package com.raezcorp.composeproject.di

import android.content.Context
import com.raezcorp.composeproject.data.repository.DataStoreOperationsImpl
import com.raezcorp.composeproject.domain.repository.DataStoreOperations
import com.raezcorp.composeproject.domain.uses_cases.UseCasesOnBoarding
import com.raezcorp.composeproject.domain.uses_cases.read_boarding.ReadOnBoardingUseCase
import com.raezcorp.composeproject.domain.uses_cases.save_boarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations {
        return DataStoreOperationsImpl(context)
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