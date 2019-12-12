package com.santiagoperdomo.arquitecturamvp.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton @Provides fun provideContext(): Context = application

}