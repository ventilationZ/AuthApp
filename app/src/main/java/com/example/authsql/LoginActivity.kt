package com.example.authsql

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPassword: EditText
    private lateinit var BtnLogin : Button
    private lateinit var BtncreateAcc :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        EdtEmail = findViewById(R.id.edtemail4lgn)
        EdtPassword = findViewById(R.id.edtpassword4lgn)
        BtncreateAcc = findViewById(R.id.btncreate4lgn)
        BtnLogin = findViewById(R.id.btnLogin4lgn)


        BtncreateAcc.setOnClickListener {
            var gotocreateacc = Intent(this,LoginActivity::class.java)
            startActivity(gotocreateacc)
        }
        BtnLogin.setOnClickListener {
            val admin = AdminSQ(this, "administracion",null,1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre_usuario", et_nombre_201.text.toString())
            registro.put("clave1", et_pasword_204.text.toString())
            registro.put("clave2",et_paword_203.text.toString() )
            bd.insert("usuario", null , registro)
            bd.close()
            et_pasword_204.setText("")
            Toast.makeText(this,"Usuarios registrado correctamente", Toast.LENGTH_SHORT).show()

        }
    }
}