package com.santiagoperdomo.dagger2.login

interface LoginMVP {

    interface View{
        fun getFirstName(): String
        fun getLastName(): String

        fun setFirstName(firstName: String)
        fun setLastName(lastName: String)

        fun enabledButtonLogin(state: Boolean)

        fun showUserNotAvailable()
        fun showUserSaved()
    }

    interface Presenter{
        fun setView(view: View)
        fun loginButtonClicked()
        fun editTextChanged()
        fun getCurrentUser()
    }

    interface Model{
        fun createUser(firstName: String, lastName: String)
        fun getUser(): User?
    }
}