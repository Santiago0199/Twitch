package com.santiagoperdomo.dagger2.login

class User(firstName: String, lastName: String) {

    var id:Int = 0
    var firstName: String
    var lastName: String

    init {
        this.firstName = firstName
        this.lastName = lastName
    }

}