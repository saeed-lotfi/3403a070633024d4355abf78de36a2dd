package com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.di

import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.ShipRepository
import com.saeedlotfi.a3403a070633024d4355abf78de36a2dd.data.repository.ShipRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {

    @Binds
    abstract fun bindShipRepository(impl: ShipRepositoryImp): ShipRepository

}