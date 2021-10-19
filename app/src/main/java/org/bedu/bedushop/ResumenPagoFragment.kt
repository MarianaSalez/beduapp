package org.bedu.bedushop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ResumenPagoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val pago = PagoExitosoFragment()
        val view = inflater.inflate(R.layout.fragment_resumen_pago, container, false)
        val button = view.findViewById<Button>(R.id.btnPagar)

        button.setOnClickListener {
            replaceFragment(pago, null)
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
    override fun onDetach() {
        super.onDetach()
        (activity as Shop).showBottomNav()
    }

}