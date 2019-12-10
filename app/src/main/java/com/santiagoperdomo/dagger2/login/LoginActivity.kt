package com.santiagoperdomo.dagger2.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.santiagoperdomo.dagger2.R
import com.santiagoperdomo.dagger2.root.MyApp
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginMVP.View {

    @Inject
    lateinit var presenter: LoginMVP.Presenter

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as MyApp).loginComponent.inject(this)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            presenter.loginButtonClicked()
        }
}

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String = this.etFirstName.text.toString().trim()

    override fun getLastName(): String = this.etLastName.text.toString().trim()

    override fun setFirstName(firstName: String) = this.etFirstName.setText(firstName)

    override fun setLastName(lastName: String) = this.etLastName.setText(lastName)

    override fun showUserNotAvailable() {
        AlertDialog.Builder(this).setTitle(R.string.error).setMessage(R.string.user_available).setPositiveButton(R.string.aceptar){
                dialogInterface, _ -> dialogInterface.dismiss()
        }.show()
    }

    override fun showUserSaved() {
        AlertDialog.Builder(this).setTitle(R.string.hecho).setMessage(R.string.user_saved).setPositiveButton(R.string.aceptar){
                dialogInterface, _ -> dialogInterface.dismiss()
        }.show()
    }
}
