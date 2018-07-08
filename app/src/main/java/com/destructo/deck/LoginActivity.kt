package com.destructo.deck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailButton: EditText = findViewById(R.id.email)
        val passwordButton: EditText = findViewById(R.id.password)
        val signInButton: Button = findViewById(R.id.signIn)

        signInButton.setOnClickListener {
            signIn(emailButton.text.toString(), passwordButton.text.toString())
        }

    }

    private fun signIn (email: String, password: String){

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this)
                    {task ->
                        if (task.isSuccessful)
                            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
        } else {
            Toast.makeText(this, "Error, fields cannot be empty", Toast.LENGTH_SHORT).show()
        }



    }
}
