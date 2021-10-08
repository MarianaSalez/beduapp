package org.bedu.bedushop

import RecyclerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recycler.*


class UsuarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_usuario, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerOptions)
        recycler.adapter = RecyclerAdapterOpciones(listOf(
            Opciones("Mis direcciones", R.drawable.ic_location,R.drawable.arrow),
            Opciones("Metodo de pago", R.drawable.credit_card,R.drawable.arrow),
            Opciones("Pedidos", R.drawable.history,R.drawable.arrow),
            Opciones("Notificaciones", R.drawable.notificacion,R.drawable.arrow),
            Opciones("Cambiar contraseña", R.drawable.lock,R.drawable.arrow)
        ))



        return view
    }

}