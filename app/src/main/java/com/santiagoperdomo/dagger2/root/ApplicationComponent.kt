package com.santiagoperdomo.dagger2.root

import com.santiagoperdomo.dagger2.login.LoginActivity
import com.santiagoperdomo.dagger2.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class])
interface ApplicationComponent {

    fun inject(target: LoginActivity)

}