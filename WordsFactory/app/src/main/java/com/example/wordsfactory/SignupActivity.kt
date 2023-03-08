package com.example.wordsfactory

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SignupActivity : AppCompatActivity() {
    private lateinit var backButton: FloatingActionButton
    private lateinit var loginButton: Button
    private lateinit var signupButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        backButton = findViewById( R.id.backButton )
        backButton.setOnClickListener {
            startActivity( Intent( this, IntroActivity::class.java ) )
        }

        loginButton = findViewById<View>( R.id.loginButton ) as Button
        signupButton = findViewById<View>( R.id.signupButton ) as Button

        nameEditText = findViewById<View>( R.id.nameEditText ) as EditText
        emailEditText = findViewById<View>( R.id.emailEditText ) as EditText
        passwordEditText = findViewById<View>( R.id.passwordEditText ) as EditText

        signupButton.setOnClickListener {
            if( nameEditText.text.isNullOrEmpty() || emailEditText.text.isNullOrEmpty() || passwordEditText.text.isNullOrEmpty() ) {
                AlertDialog.Builder( this )
                    .setTitle( android.R.string.dialog_alert_title )
                    .setMessage( "One or more fields are not filled out. Please check if all fields are filled in and try again." )
                    .setPositiveButton( resources.getString( android.R.string.ok ) ) {
                            dialog, _ -> dialog.cancel()
                    }
                    .show()
            } else {
                startActivity( Intent( this, DictionaryActivity::class.java ) )
            }
        }

        loginButton.setOnClickListener {
            startActivity( Intent( this, DictionaryActivity::class.java ) )
        }
    }
}