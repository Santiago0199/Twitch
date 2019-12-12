package com.santiagoperdomo.arquitecturamvp.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter(model: LoginMVP.Model): LoginMVP.Presenter{
        return LoginPresenter(model)
    }

    @Provides
    fun provideLoginModel(repository: LoginRepository): LoginMVP.Model{
        return LoginModel(repository)
    }

    @Provides
    fun provideLoginRepository(): LoginRepository {
        return MemoryRepository()
    }

}