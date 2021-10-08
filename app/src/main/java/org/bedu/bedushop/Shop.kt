package org.bedu.bedushop

import android.app.ActivityOptions
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
//import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.net.Uri
import android.transition.TransitionInflater
import android.view.*
import android.widget.*
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.recycler_perfil.*


class Shop : AppCompatActivity() {

    private  var usuarioFragment= UsuarioFragment()
    private  var listaFragment= ListadoFragment()
    private  var carritoFragment= CarritoFragment()
    private lateinit var menuSuperior: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


        //!! Transition sin terminar para el detail
       val transitionXml = TransitionInflater.from(this).inflateTransition(R.transition.descripcion).apply {
            excludeTarget(window.decorView.findViewById<View>(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }
        window.exitTransition = transitionXml
        //!! Transition sin terminar para el detail



        /*Inicializa frament segun su origen
        * Se es por Inicio seccion o registrar o DETAIL*/
        val origen : String = intent.getStringExtra("origen").toString()
        if(origen == "DETAIL"){
            replaceFragment(carritoFragment)
            Toast.makeText(this, "Producto Agregado", Toast.LENGTH_SHORT).show()
        }
        else{
            replaceFragment(listaFragment)
        }


        /*Controlador del navegador
        * Dependiendo lo que seleccione el usuario en el Bottom Nav te envia a dicho fragment*/
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

        /*Iniciar actividad Detail*/

        listaFragment.setListener{
            val detailFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? DetailFragment

            // Pantalla grande, mostrar detalle en el fragment
            if(detailFragment!=null){
                detailFragment.showProduct(it)
            } else{ //pantalla pequeña, navegar a un nuevo Activity
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT,it)

                //!! Transition sin terminar para el detail

               // EN ESTA SECCION PROBE DE USAR SHARED TRANSITION PERO NO ME GUSTO EL RESULTADO, PREGUNTAR A JAVI

               /* val options = ViewCompat.getTransitionName(findViewById(R.id.cardviewLista))?.let {
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this, findViewById(R.id.cardviewLista), it
                    )
                }*/

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
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
        // Funcion que te levanta el fragment que se pasa por parametro
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