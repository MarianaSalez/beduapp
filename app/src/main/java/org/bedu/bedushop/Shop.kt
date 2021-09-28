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

    private  var usuarioFragment= UsuarioFragment()
    private  var listaFragment= ListadoFragment()
    private  var carritoFragment= CarritoFragment()
    private lateinit var menuSuperior: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


        replaceFragment(listaFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_carrito -> {
                    replaceFragment(carritoFragment)
                    true
                }

                R.id.menu_usuario -> {
                    replaceFragment(usuarioFragment)
                    true
                }
                R.id.ic_inicio -> {
                    replaceFragment(listaFragment)
                    true
                }
                else -> {
                    false
                }
            }


        }
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

    private fun replaceFragment(fragment: Fragment){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragemento_contenedor, fragment)
        trans.addToBackStack(null)
        trans.commit()
    }
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            val inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.menu_superior, menu)
            return true
        }
}