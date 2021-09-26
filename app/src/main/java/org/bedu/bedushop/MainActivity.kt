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

class MainActivity : AppCompatActivity() {

    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var registro: Button
    private lateinit var inicio: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail = findViewById(R.id.EmailAddress)
        pass = findViewById(R.id.Password)
        registro = findViewById(R.id.registro)
        inicio = findViewById(R.id.inicio)


        //Verificacion de que no este vacios los input
        fun validarForm(): Boolean {
            var esValido = true

            if (TextUtils.isEmpty(mail.text.toString())) {
                // Si la propiedad error tiene valor, se muestra el aviso.
                mail.error = "Correo requerido"
                esValido = false
            } else mail.error = null

            if (TextUtils.isEmpty(pass.text.toString())) {
                pass.error = "Contraseña requerida"
                esValido = false
            } else pass.error = null

            return esValido
        }

        inicio.setOnClickListener{
            if(validarForm()){
                Toast.makeText(this, "Inicio de Sesión exitoso", Toast.LENGTH_SHORT).show()
            }
        }


       /*

       registro.setOnClickListener{
            val intent=Intent(this, RegisterActivity::class.java).apply {  }
            startActivity(intent)}

        inicio.setOnClickListener {
            if (mail.equals("")) {
                validarMail.visibility = View.VISIBLE
            } else if (pass.equals("")) {
                validarPass.visibility = View.VISIBLE
            } else {
                Toast.makeText(this, "Inicio de Sesion correcto", Toast.LENGTH_SHORT).show()

            }
        }*/
    }
}

