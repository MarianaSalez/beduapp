package org.bedu.bedushop

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
        name: String,
        mail: String,
        phone: String,
        pass: String
    ): Boolean {

        if (name .isEmpty()|| mail.isEmpty() || phone.isEmpty() || pass.isEmpty()){
            return false
        }

        if(!("@" in mail)){
            return false
        }

        if(phone.toString().length!=10){
            return false
        }
        if(8>pass.toString().length || pass.toString().length>16){
            return false
        }

        return true
    }

    //fun isEmailValid(email: String): Boolean {
      //  return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
  //  }
}