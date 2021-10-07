package org.bedu.bedushop

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import android.transition.TransitionInflater
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


        //! TRANSITIONS A MEJORAR
        val transitionXml = TransitionInflater.from(this).inflateTransition(R.transition.login).apply {
            excludeTarget(window.decorView.findViewById<View>(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        window.exitTransition = transitionXml

        //! TRANSITIONS A MEJORAR

        //cargo los datos del login
        mail= findViewById(R.id.editTextEmail)
        pass = findViewById(R.id.editPassword)
        registro = findViewById(R.id.registro)
        inicio = findViewById(R.id.inicio)

        //valido que los datos del login no encuentren vacios, limitando el tipo de entrado
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

        // Si se selecciona el boton de inciar seccion, se valida los datos y si estan correcto se redireccionan al Activity Shop
        inicio.setOnClickListener{

            if(validarForm()){
                val intent=Intent(this, Shop::class.java).apply {  }
                startActivity(intent)}

        }

        // Si se selecciona el registro te envia al Activity de Registrar
        registro.setOnClickListener{
            val intent=Intent(this, Registrar::class.java).apply {  }
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())}

    }
}

