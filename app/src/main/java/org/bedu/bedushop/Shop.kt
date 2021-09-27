package org.bedu.bedushop

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class Shop : AppCompatActivity() {

    private lateinit var usuarioFragment: UsuarioFragment
    private lateinit var listaFragment: ListadoFragment
    private lateinit var carritoFragment: CarritoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

    }


}