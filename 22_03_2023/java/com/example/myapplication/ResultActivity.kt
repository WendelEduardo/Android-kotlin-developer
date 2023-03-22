package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = findViewById<TextView>(R.id.result);
        val bundle= intent.extras

        if(bundle != null){
            result.text = "${bundle.getString("res")}"
        }

        val buttonGoBack = findViewById<Button>(R.id.gobackbtn);

        buttonGoBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}