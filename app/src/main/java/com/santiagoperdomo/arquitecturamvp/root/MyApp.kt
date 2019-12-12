package com.santiagoperdomo.arquitecturamvp.root

import android.app.Application
import com.santiagoperdomo.arquitecturamvp.login.LoginModule

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