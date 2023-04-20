package com.example.authsql

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPassword: EditText
    private lateinit var BtnLogin : Button
    private lateinit var BtncreateAcc :Button
    private lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        EdtEmail = findViewById(R.id.edtemail4lgn)
        EdtPassword = findViewById(R.id.edtpassword4lgn)
        BtncreateAcc = findViewById(R.id.btncreate4lgn)
        BtnLogin = findViewById(R.id.btnLogin4lgn)


        BtncreateAcc.setOnClickListener {
            var gotocreateacc = Intent(this,MainActivity::class.java)
            startActivity(gotocreateacc)
        }
        BtnLogin.setOnClickListener {
            var emailedt = EdtEmail.text.toString().trim()
            var passwordedt = EdtPassword.text.toString().trim()
            //validate
            if (emailedt.isEmpty() || passwordedt.isEmpty())
                Toast.makeText(this, "Can't submit Check your Input", Toast.LENGTH_SHORT).show()
            else{
                val cursor = db.rawQuery("SELECT * FROM users WHERE arafa=? AND siri=?", arrayOf(emailedt, passwordedt))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }


            }
    }
}
}
