package com.intuitivehome.app.di
import com.intuitivehome.app.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module @InstallIn(SingletonComponent::class)
object AppModule {
    @Provides @Singleton fun provideLlmService(): LlmService = MockLlmService()
    @Provides @Singleton fun provideDeviceGraphService(): DeviceGraphService = MockDeviceGraphService()
    @Provides @Singleton fun provideAccessControlService(): AccessControlService = MockAccessControlService()
    @Provides @Singleton fun provideCameraService(): CameraService = MockCameraService()
}