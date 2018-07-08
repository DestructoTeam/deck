package com.destructo.deck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailButton: EditText = findViewById(R.id.email)
        val passwordButton: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.login)

        loginButton.setOnClickListener {
            login(emailButton.text.toString(), passwordButton.text.toString())
        }
    }

    private fun login (email: String, password: String){

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT)
                        } else {
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
                        }
                    }
        }
    }
}
