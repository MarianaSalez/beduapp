package org.bedu.bedushop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class ResumenNotificacionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val menu = CarritoFragment()
        val view = inflater.inflate(R.layout.fragment_resumen_notificacion, container, false)
        val button = view.findViewById<Button>(R.id.btnVolverCarrito)
        val totalTvNotificacion = view.findViewById<TextView>(R.id.totalTvNotificacion)

        //Recuperamos datos del bundle desde la actividad shop
        val valorTotal = this.arguments?.getString(RESUMEN_VALOR)

        totalTvNotificacion.text = "$" + valorTotal.toString()

        button.setOnClickListener {
            replaceFragment(menu, null)
            (activity as Shop).showBottomNav()
        }

        super.onViewCreated(view, savedInstanceState)
        (activity as Shop).hideBottomNav()


        return view
    }

    private fun replaceFragment(fragment: Fragment, bundle:Bundle?){
        fragment.arguments = bundle//Enviamos Bundle, de existir
        val trans = requireActivity().supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragemento_contenedor, fragment)
        trans.addToBackStack(null)
        trans.commit()
    }


}