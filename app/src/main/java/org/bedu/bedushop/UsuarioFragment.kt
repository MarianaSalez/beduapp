package org.bedu.bedushop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class UsuarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonUsuario = view.findViewById<Button>(R.id.menu_usuario)
        buttonUsuario?.setOnClickListener {
            findNavController().navigate(R.id.usuarioFragment, null)
        }
        val buttonCarrito = view.findViewById<Button>(R.id.menu_carrito)
        buttonCarrito?.setOnClickListener {
            findNavController().navigate(R.id.carritoFragment, null)
        }
        val buttonListado = view.findViewById<Button>(R.id.ic_inicio)
        buttonListado?.setOnClickListener {
            findNavController().navigate(R.id.listadoFragment, null)
        }
    }
}