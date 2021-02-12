package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.di

import android.content.Context
import android.content.SharedPreferences
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.BuildConfig.APPLICATION_ID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun getSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(APPLICATION_ID, Context.MODE_PRIVATE)

//    @Provides
//    @Singleton
//    fun createDatabase(@ApplicationContext context: Context): ShipDatabase =
//        Room.databaseBuilder(context, ShipDatabase::class.java, DATABASE_NAME).build()
//
//
//    @Provides
//    @Singleton
//    fun getMovieSearchDao(db: MovieDatabase) = db.getMovieSearchDao()
//
//    @Provides
//    @Singleton
//    fun getRetrofit(): ApiService =
//        Retrofit.Builder().baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)

}