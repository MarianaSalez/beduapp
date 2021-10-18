package org.bedu.bedushop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_carrito.*


class CarritoFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapterCarrito
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


        //Funcion para pasar al fragment de compra
        val boton = view.findViewById<Button>(R.id.buttonComprar)
        boton.setOnClickListener {
            replaceFragment(resumen, null)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
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
        /*val realm = Realm.getDefaultInstance()
        products = realm.where(Product::class.java).findAll()
        val product = intent.getIntExtra("id", 0)
        var product = products[id].id
        val marketObject =
            supportFragmentManager.findFragmentById(R.id.recyclerCarrito) as? CarritoFragment
        if (product != null) {
            marketObject?.showInMarket(product, products)
        }*/
    }


        //funcion en proceso para linkear elementos on lo visual

        fun showInMarket(id: Int, product: List<Product>) {
            val producto=product[id]
            view?.visibility = View.VISIBLE
            mpName.text = producto.name
           Picasso.with(requireContext()).load(producto.idImage).into(mpimg)
           mpPrice.text = "$${producto.price}"

        }


    private fun setUpRecyclerView() {
        var listStr = this.arguments?.getString(SHOP_LIST)
        val listProductType = object : TypeToken<MutableList<ProductoApi>>(){}.type
        val prods = Gson().fromJson<MutableList<ProductoApi>>(listStr, listProductType)
        //Log.d("setUpRecycler", prods.toString())
        recyclerCarrito.setHasFixedSize(true)
        recyclerCarrito.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        val testProd : MutableList<ProductoApi> = mutableListOf()
        testProd.add(ProductoApi("Mochila", 21.50f, "Mochila test", rating(4.10,50), "https://http2.mlstatic.com/D_NQ_NP_746908-MLA46933276297_072021-O.webp"))
        testProd.add(ProductoApi("Mochila", 21.50f, "Mochila test", rating(4.10,50), "https://http2.mlstatic.com/D_NQ_NP_746908-MLA46933276297_072021-O.webp"))
        mAdapter = RecyclerAdapterCarrito(requireActivity(), testProd)//esto es uma prueba
        //asignando el Adapter al RecyclerView
        recyclerCarrito.adapter = mAdapter
    }
    }
