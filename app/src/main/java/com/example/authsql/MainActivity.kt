package com.example.authsql

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var Btncreate :Button
    private lateinit var EdtFirstName: EditText
    private lateinit var EdtSecondName: EditText
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPassword: EditText
    private lateinit var db: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btncreate = findViewById(R.id.btncreate)
        EdtFirstName = findViewById(R.id.edtfirstname)
        EdtSecondName = findViewById(R.id.edtsecondname)
        EdtEmail = findViewById(R.id.edtemail)
        EdtPassword = findViewById(R.id.edtpassword)

        db =openOrCreateDatabase("ElijahDB", Context.MODE_PRIVATE, null)

        db.execSQL("CREATE TABLE IF NOT EXISTS users(jinalakwanza VARCHAR,jinalapili VARCHAR,arafa VARCHAR,siri VARCHAR)")

        Btncreate.setOnClickListener {
            var first_name_edt = EdtFirstName.text.toString().trim()
            var second_name_edt = EdtSecondName.text.toString().trim()
            var email_edt = EdtEmail.text.toString().trim()
            var password_edt = EdtPassword.text.toString().trim()
            if (first_name_edt.isEmpty() || email_edt.isEmpty() || second_name_edt.isEmpty()|| password_edt.isEmpty())
                Toast.makeText(this, "Check your Input", Toast.LENGTH_SHORT).show()
            else{
                db.execSQL("INSERT INTO users VALUES('"+first_name_edt+"','"+email_edt+"','"+second_name_edt+"','"+password_edt+"')")
                Toast.makeText(this, "USER SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

            var gotologin =Intent(this,LoginActivity::class.java)
            startActivity(gotologin)
            }
        }
    }
}