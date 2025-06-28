package app.prueba.pruebatecnica.di

import app.prueba.pruebatecnica.data.respository.PlanetRepositoryImpl
import app.prueba.pruebatecnica.data.respository.UserRepositoryImpl
import app.prueba.pruebatecnica.domain.repository.PlanetRepository
import app.prueba.pruebatecnica.domain.repository.UserRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepositoryInterface

    @Binds
    @Singleton
    abstract fun bindPlanetRepository(
        impl: PlanetRepositoryImpl
    ): PlanetRepository
}
