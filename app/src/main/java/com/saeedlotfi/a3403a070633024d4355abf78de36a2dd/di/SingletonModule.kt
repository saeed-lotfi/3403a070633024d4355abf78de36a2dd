package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.BuildConfig.APPLICATION_ID
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.local.db.ShipDatabase
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.remote.ApiService
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.BASE_URL
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
            context.getSharedPreferences(APPLICATION_ID, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun createDatabase(@ApplicationContext context: Context): ShipDatabase =
            Room.databaseBuilder(context, ShipDatabase::class.java, DATABASE_NAME).build()


    @Provides
    @Singleton
    fun getMovieSearchDao(db: ShipDatabase) = db.stationsDao()


    @Provides
    @Singleton
    fun getGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory): ApiService =
            Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .build()
                    .create(ApiService::class.java)

}