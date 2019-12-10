package com.santiagoperdomo.dagger2.login

interface LoginRepository {

    fun saveUser(user: User?)
    fun getUser(): User

}