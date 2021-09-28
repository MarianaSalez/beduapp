package org.bedu.bedushop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.material.textfield.TextInputEditText

class Registrar : AppCompatActivity() {

    private lateinit var name: TextInputEditText
    private lateinit var mail: TextInputEditText
    private lateinit var phone: TextInputEditText
    private lateinit var pass: TextInputEditText
    private lateinit var registro: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        name= findViewById(R.id.completeNameR)
        mail= findViewById(R.id.editTextEmailR)
        phone=findViewById(R.id.phoneR)
        pass = findViewById(R.id.editPasswordR)

        registro = findViewById(R.id.btnRegistrar)

        fun validarForm(): Boolean {
            var esValido = true

            if (TextUtils.isEmpty(name.getText())) {
                name.error = getString(R.string.requerido)
                esValido = false
            } else name.error = null

            if (TextUtils.isEmpty(mail.getText())) {
                mail.error = getString(R.string.requerido)
                esValido = false
            } else mail.error = null

            if (TextUtils.isEmpty(phone.getText())) {
                phone.error = getString(R.string.requerido)
                esValido = false
            } else phone.error = null

            if (TextUtils.isEmpty(pass.getText())) {
                pass.error = getString(R.string.requerido)
                esValido = false
            } else pass.error = null

            return esValido
        }



        registro.setOnClickListener{

            if(validarForm()){
                val intent=Intent(this, MainActivity::class.java).apply {  }
                startActivity(intent)}
            }
        }

}


