package com.limcg.espressotesting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            if(user_name.text.toString().equals("limcg") &&
                    password.text.toString().equals("password"))
                Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show()
        }


    }
}