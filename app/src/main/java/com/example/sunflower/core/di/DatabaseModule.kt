package com.example.sunflower.core.di

import android.content.Context
import androidx.room.Room
import com.example.sunflower.core.db.photo.PhotoDatabase
import com.example.sunflower.core.db.photo.PhotoDao
import com.example.sunflower.core.db.photo.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): PhotoDatabase {
        return Room.databaseBuilder(
            appContext,
            PhotoDatabase::class.java,
            "photo_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: PhotoDatabase): PhotoDao {
        return database.photoDao()
    }

    @Singleton
    @Provides
    fun provideUserRepository(userDao: PhotoDao): PhotoRepository {
        return PhotoRepository(userDao)
    }
}