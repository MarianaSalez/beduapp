package org.bedu.bedushop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController


class ListadoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonUsuario = view.findViewById<Button>(R.id.menu_usuario)
        buttonUsuario?.setOnClickListener {
            Toast.makeText(requireContext(),"Usuario",Toast.LENGTH_SHORT).show()
        }
        val buttonCarrito = view.findViewById<Button>(R.id.menu_carrito)
        buttonCarrito?.setOnClickListener {
            Toast.makeText(requireContext(),"Carrito",Toast.LENGTH_SHORT).show()
        }
        val buttonListado = view.findViewById<Button>(R.id.ic_inicio)
        buttonListado?.setOnClickListener {
            Toast.makeText(requireContext(),"Listado",Toast.LENGTH_SHORT).show()
        }
    }
}