package com.santiagoperdomo.dagger2.root

import android.app.Application
import com.santiagoperdomo.dagger2.login.LoginModule

class MyApp: Application() {

    lateinit var loginComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        loginComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .loginModule(LoginModule())
            .build()
    }

}