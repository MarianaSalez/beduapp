package org.bedu.bedushop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Login : AppCompatActivity() {
    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var registro: Button
    private lateinit var inicio: Button
    private lateinit var validarMail: TextView
    private lateinit var validarPass: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail = findViewById(R.id.EmailAddress)
        pass = findViewById(R.id.Password)
        registro = findViewById(R.id.registro)
        inicio = findViewById(R.id.inicio)
        validarMail = findViewById(R.id.mailInvalido)
        validarPass = findViewById(R.id.passwordIncorrecto)

        inicio.setOnClickListener {
            if (mail.equals("")) {
                validarMail.visibility = View.VISIBLE
            } else if (pass.equals("")) {
                validarPass.visibility = View.VISIBLE
            } else {
                Toast.makeText(this, "Inicio de Sesion correcto", Toast.LENGTH_SHORT).show()

            }
        }
    }
}