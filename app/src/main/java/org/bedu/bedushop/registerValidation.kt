package org.bedu.bedushop

import android.app.Activity
import android.content.Context
import android.text.Layout
import android.text.TextUtils
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlin.coroutines.coroutineContext

/*
* Test que debe pasar:
* Ningun campo sea nulo
* que el mail contenga un arroba
* que el telefono contenga 10 numeros
* que el password contenga al minimo 8 caracteres
*que el password tenga max 16 caract
*
* OPCIONAL: que consuma de la api y no se repita usuario existente
* */

object registerValidation {

    fun validarForm(
        name: TextInputEditText,
        mail: TextInputEditText,
        phone: TextInputEditText,
        pass: TextInputEditText
    ): Boolean {



        if(!(mail.text?.contains("@"))!! || !(mail.text?.contains(".com"))!!){
            mail.error = "Ingrese un email valido"
            return false
        }

        if(phone.text.toString().length != 10){
            phone.doOnTextChanged { text, start, before, count ->
                if(text!!.length > 10){
                    phone.error = "Solo hasta 10 numeros"
                }
            }
            return false
        }
        if(pass.text.toString().length < 8){
            pass.error = "El minimo son 8 caracteres"
            return false
        }

        if(pass.text.toString().length > 16){
            pass.doOnTextChanged { text, start, before, count ->
                if(text!!.length > 16){
                    pass.error = "El maximo son 16 caracteres "
                }
            }
            return false
        }

        if (name.text.toString().isEmpty()|| mail.toString().isEmpty() || phone.toString().isEmpty() || pass.toString().isEmpty()){
            return false
        }

        return true
    }

}

