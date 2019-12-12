package com.santiagoperdomo.arquitecturamvp.login

interface LoginRepository {

    fun saveUser(user: User?)
    fun getUser(): User

}