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
import android.widget.*
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

    //Esta es la lista de Productos que tenemos real en el carrito, por sus id
    private var products : MutableList<ProductoApi> = mutableListOf()
    private var idProducts : MutableList<Int> = mutableListOf()

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
        val bundleDesdeDetail = arguments?.getParcelable<ProductoApi>(SHOP_PRODUCT)!! //No hay persistencia en el array!

//Si no fallo mim bundle, y por lo tanto no es nulo
            if(bundleDesdeDetail.id!=null){
                if ((products.find{it.id in idProducts})!=null){
                    products[id].stock++
                    Log.d("cantidad","cambiar")
                    Log.d("Stock", products[id].stock.toString())
                }
                else{
                    products.add(bundleDesdeDetail)
                    idProducts.add(bundleDesdeDetail.id)
                    Log.d("crear","itemnuevo")
                }
                    setUpRecyclerView(products)
            }
}

private fun replaceFragment(fragment: Fragment, bundle: Bundle?) {
fragment.arguments = bundle//Enviamos Bundle, de existir
val trans = requireActivity().supportFragmentManager.beginTransaction()
trans.replace(R.id.fragemento_contenedor, fragment)
trans.addToBackStack(null)
trans.commit()
}


private fun setUpRecyclerView(listadoProductosCarrito : MutableList<ProductoApi>) {
var listStr = this.arguments?.getString(MainApp.array)
val listProductType = object : TypeToken<MutableList<ProductoApi>>(){}.type
val prods = Gson().fromJson<MutableList<ProductoApi>>(listStr, listProductType)
//Log.d("setUpRecycler", prods.toString())
recyclerCarrito.setHasFixedSize(true)
recyclerCarrito.layoutManager = LinearLayoutManager(activity)
//seteando el Adapter
/*val testProd : MutableList<ProductoApi> = mutableListOf()
testProd.add(ProductoApi(1,"Mochila", 21.50f, "Mochila test", rating(4.10,50), "https://http2.mlstatic.com/D_NQ_NP_746908-MLA46933276297_072021-O.webp"))
testProd.add(ProductoApi(2,"Mochila", 21.50f, "Mochila test", rating(4.10,50), "https://http2.mlstatic.com/D_NQ_NP_746908-MLA46933276297_072021-O.webp"))
*/

mAdapter = RecyclerAdapterCarrito(requireActivity(), listadoProductosCarrito)//esto es uma prueba
//asignando el Adapter al RecyclerView
recyclerCarrito.adapter = mAdapter
}
}
