package org.bedu.bedushop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import io.realm.Realm


class CarritoFragment : Fragment() {


    private lateinit var mpName: TextView
    private lateinit var mpimg: ImageView
    private lateinit var mpPrice: TextView
    private lateinit var products: List<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val resumen = ResumenPagoFragment()
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)


        //Me traigo lo visual
        mpName = view.findViewById(R.id.titleCarrito)
        mpimg = view.findViewById(R.id.carritoImageView)
        mpPrice = view.findViewById(R.id.priceCarrito)

        //Funcion para pasar al fragment de compra
        val boton = view.findViewById<Button>(R.id.buttonComprar)
        boton.setOnClickListener {
            replaceFragment(resumen, null)
        }

        return view
    }

    private fun replaceFragment(fragment: Fragment, bundle: Bundle?) {
        fragment.arguments = bundle//Enviamos Bundle, de existir
        val trans = requireActivity().supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragemento_contenedor, fragment)
        trans.addToBackStack(null)
        trans.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val realm = Realm.getDefaultInstance()
        products = realm.where(Product::class.java).findAll()

        val id = intent.getIntExtra("id", 0)
        var product = products[id].id
        val marketObject =
            supportFragmentManager.findFragmentById(R.id.recyclerCarrito) as? CarritoFragment
        if (product != null) {
            marketObject?.showInMarket(product, products)


        }
    }


        //funcion en proceso para linkear elementos on lo visual

        fun showInMarket(id: Int, product: List<Product>) {
            val producto=product[id]
            view?.visibility = View.VISIBLE
            mpName.text = producto.name
           Picasso.with(requireContext()).load(producto.idImage).into(mpimg)
           mpPrice.text = "$${producto.price}"

        }
    }
}