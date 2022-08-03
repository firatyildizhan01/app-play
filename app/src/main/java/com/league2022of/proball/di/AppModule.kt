package com.league2022of.proball.di

import android.content.Context
import androidx.room.Room
import com.league2022of.proball.api.ApiService
import com.league2022of.proball.db.SportDatabase
import com.league2022of.proball.utils.Constants
import com.league2022of.proball.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideSportDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, SportDatabase
        ::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideToDoDao(
        db: SportDatabase
    ) = db.sportDao()
}