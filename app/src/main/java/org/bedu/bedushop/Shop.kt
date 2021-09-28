package org.bedu.bedushop

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
//import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.net.Uri
import android.view.*
import androidx.core.content.ContextCompat.startActivity


class Shop : AppCompatActivity() {

    private lateinit var usuarioFragment: UsuarioFragment
    private lateinit var listaFragment: ListadoFragment
    private lateinit var carritoFragment: CarritoFragment
    private lateinit var menuSuperior: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_superior, menu)
        return true
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle item selection
            return when (item.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Función no disponible", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.help -> {
                    val url = "https://www.bedu.org"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }

}