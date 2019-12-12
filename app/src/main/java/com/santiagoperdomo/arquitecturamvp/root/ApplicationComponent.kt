package com.santiagoperdomo.arquitecturamvp.root

import com.santiagoperdomo.arquitecturamvp.http.TwitchModule
import com.santiagoperdomo.arquitecturamvp.login.LoginActivity
import com.santiagoperdomo.arquitecturamvp.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class, TwitchModule::class])
interface ApplicationComponent {

    fun inject(target: LoginActivity)

}