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

/*
    //Para el boton de google

    var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
    SignInButton signInButton = findViewById(R.id.sign_in_button)
    signInButton.setSize(SignInButton.SIZE_STANDARD)
    findViewById(R.id.sign_in_button).setOnClickListener(this);
    fun onClick(v: View) {
        when (v.getId()) {
            R.id.sign_in_button -> signIn()
        }
    }
    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
            try {
                GoogleSignInAccount account = completedTask.getResult(ApiException.class);

                // Signed in successfully, show authenticated UI.
                updateUI(account);
            } catch (ApiException e) {
                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.
                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                updateUI(null);
            }
        }
    }*/
