package app.prueba.pruebatecnica.di

import android.content.Context
import androidx.room.Room
import app.prueba.pruebatecnica.data.local.AppDatabase
import app.prueba.pruebatecnica.data.local.UserDao
import app.prueba.pruebatecnica.data.respository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_pruebas").build()

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepositoryImpl =
        UserRepositoryImpl(userDao)
}