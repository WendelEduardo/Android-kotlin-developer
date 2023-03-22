package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    val users: MutableList<String> = mutableListOf("user1", "user2");
    val emails: MutableList<String> = mutableListOf("email1", "email2");
    val passwords: MutableList<String> = mutableListOf("pass1", "pass2");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.signupbtn);

        btn.setOnClickListener {
            val username = findViewById<EditText>(R.id.username);
            val userInput = username.text.toString();

            var result = "User successfuly registered"
            var bundle = Bundle();

            if (users.contains(userInput)) {
                result = "User already registered. Insert the password"

            } else if(userInput.isEmpty() || userInput.equals("")) {
                result = "User empty, type a valid user"
            } else {

                val email = findViewById<EditText>(R.id.email);
                val emailInput = email.text.toString();

                val password = findViewById<EditText>(R.id.password);
                val passwordInput = password.text.toString();

                val repassword = findViewById<EditText>(R.id.repassword);
                val repasswordInput = repassword.text.toString();

                if (passwordInput.equals(repasswordInput)) {
                    users.add(userInput);
                    emails.add(emailInput);
                    passwords.add(passwordInput);
                } else {
                    result = "Password does not match."

                }

            }

            bundle.putString("res", result);
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        /*btn.setOnClickListener(object : View.OnClickListener {
            override fun onclick(view: View) {

            }
        })

        btn.setOnClickListener(View.OnClickListener { view ->

        })*/

    }


}