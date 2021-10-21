package org.bedu.bedushop.Inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import org.bedu.bedushop.Inicio.registerValidation.validarForm
import org.bedu.bedushop.R


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


        // Boton de registrar, valida el formulario y te envia el Inicio de Seccion
        registro.setOnClickListener{
            if(validarForm(name,mail,phone,pass)){
                val intent=Intent(this, MainActivity::class.java).apply {  }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }


    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}


