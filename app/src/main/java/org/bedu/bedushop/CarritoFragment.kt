package org.bedu.bedushop

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


class CarritoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrito, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonUsuario = view.findViewById<Button>(R.id.menu_usuario)
        buttonUsuario?.setOnClickListener {
            //findNavController().navigate(R.id.usuarioFragment, null)
            Toast.makeText(requireContext(),"Usuario", Toast.LENGTH_SHORT).show()
        }
        val buttonCarrito = view.findViewById<Button>(R.id.menu_carrito)
        buttonCarrito?.setOnClickListener {
            Toast.makeText(requireContext(),"Carrito",Toast.LENGTH_SHORT).show()
        }
        val buttonListado = view.findViewById<Button>(R.id.ic_inicio)
        buttonListado?.setOnClickListener {
            Toast.makeText(requireContext(),"Carrito",Toast.LENGTH_SHORT).show()
        }
    }
}