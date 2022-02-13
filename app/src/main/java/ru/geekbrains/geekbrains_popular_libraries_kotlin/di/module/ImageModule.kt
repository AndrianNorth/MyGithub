package ru.geekbrains.geekbrains_popular_libraries_kotlin.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.IImageCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.cache.room.RoomImageCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.image.IImageLoader
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.network.INetworkStatus
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.image.GlideImageLoader
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("imageCache")
    @Singleton
    @Provides
    fun imageCacheDir(app: App): File = app.externalCacheDir?: app.cacheDir

    @Singleton
    @Provides
    fun imageLoader(cache: IImageCache, networkStatus: INetworkStatus): IImageLoader<ImageView> = GlideImageLoader(cache, networkStatus)

    @Singleton
    @Provides
    fun imageCache(database: Database, @Named("imageCache") imageCacheDir: File): IImageCache = RoomImageCache(database, imageCacheDir)
}