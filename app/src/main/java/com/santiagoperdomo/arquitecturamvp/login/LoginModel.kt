package com.santiagoperdomo.arquitecturamvp.login

class LoginModel(repository: LoginRepository): LoginMVP.Model {

    private var repository: LoginRepository

    init {
        this.repository = repository
    }

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName, lastName))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }
}