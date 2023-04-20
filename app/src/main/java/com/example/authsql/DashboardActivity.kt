package com.example.authsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    private lateinit var BtnLogout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        BtnLogout=findViewById(R.id.btnlogout)

        BtnLogout.setOnClickListener {
            var gotologout = Intent(this,MainActivity::class.java)
            startActivity(gotologout)
        }
    }
}