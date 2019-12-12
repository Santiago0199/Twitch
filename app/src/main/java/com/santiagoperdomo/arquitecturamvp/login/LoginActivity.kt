package com.santiagoperdomo.arquitecturamvp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.santiagoperdomo.arquitecturamvp.R
import com.santiagoperdomo.arquitecturamvp.http.TwitchAPI
import com.santiagoperdomo.arquitecturamvp.http.twitch.Twitch
import com.santiagoperdomo.arquitecturamvp.root.MyApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginMVP.View, TextWatcher {

    @Inject
    lateinit var twitchAPI: TwitchAPI

    @Inject
    lateinit var presenter: LoginMVP.Presenter

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as MyApp).loginComponent.inject(this)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        btnLogin = findViewById(R.id.btnLogin)

        etFirstName.addTextChangedListener(this)
        etLastName.addTextChangedListener(this)
        btnLogin.setOnClickListener { presenter.loginButtonClicked() }

        val call = twitchAPI.getTopGames("mr6smatcltshgvwkvk3qlwvwkcltbu")
        call.enqueue(object : Callback<Twitch>{
            override fun onResponse(call: Call<Twitch>, response: Response<Twitch>) {
                val topGames = response.body()!!.game
                for(game in topGames!!){
                    println(game.name)
                }
            }
            override fun onFailure(call: Call<Twitch>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String = etFirstName.text.toString().trim()

    override fun getLastName(): String = this.etLastName.text.toString().trim()

    override fun setFirstName(firstName: String) = etFirstName.setText(firstName)

    override fun setLastName(lastName: String) = etLastName.setText(lastName)

    override fun enabledButtonLogin(state: Boolean){
        btnLogin.isEnabled = state
    }

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

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        presenter.editTextChanged()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }
}
