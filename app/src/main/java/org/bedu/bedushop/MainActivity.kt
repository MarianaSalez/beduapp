package org.bedu.bedushop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var mail:TextInputEditText
    private lateinit var pass: TextInputEditText
    private lateinit var registro: Button
    private lateinit var inicio: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail= findViewById(R.id.editTextEmail)
        pass = findViewById(R.id.editPassword)
        registro = findViewById(R.id.registro)
        inicio = findViewById(R.id.inicio)


        fun validarForm(): Boolean {
            var esValido = true

            if (TextUtils.isEmpty(mail.getText())) {
                mail.error = getString(R.string.error1)
                esValido = false
            } else mail.error = null

            if (TextUtils.isEmpty(pass.getText())) {
                pass.error = getString(R.string.error1)
                esValido = false
            } else pass.error = null

            return esValido
        }

        inicio.setOnClickListener{

            if(validarForm()){
                val intent=Intent(this, Shop::class.java).apply {  }
                startActivity(intent)}

        }

        registro.setOnClickListener{
            val intent=Intent(this, Registrar::class.java).apply {  }
            startActivity(intent)}

    }
}

