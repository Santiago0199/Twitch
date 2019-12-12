package com.santiagoperdomo.dagger2.login

import androidx.annotation.Nullable

class LoginPresenter(model: LoginMVP.Model): LoginMVP.Presenter{

    @Nullable
    private var view: LoginMVP.View? = null
    private var model: LoginMVP.Model

    init {
        this.model = model
    }

    override fun setView(view: LoginMVP.View) {
        this.view = view
    }

    override fun editTextChanged() {
        if(view != null){
            view!!.enabledButtonLogin(view!!.getFirstName().trim() != "" && view!!.getLastName().trim() !== "")
        }
    }

    override fun loginButtonClicked() {
        if(view != null){
            model.createUser(view!!.getFirstName(), view!!.getLastName())
            view!!.showUserSaved()
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser()
        if(user == null){
            if(view != null){
                view!!.showUserNotAvailable()
            }
        }else{
            if(view != null){
                view!!.setFirstName(user.firstName)
                view!!.setLastName(user.lastName)
            }
        }
    }
}