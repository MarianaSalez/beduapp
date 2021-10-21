package org.bedu.bedushop.shop.listado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.bedu.bedushop.Producto.MainApp
import org.bedu.bedushop.Producto.ProductoApi
import org.bedu.bedushop.R
import org.bedu.bedushop.shop.SHOP_LIST


class ListadoFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapter
    private var listener : (ProductoApi) ->Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout de fragment
        return inflater.inflate(R.layout.fragment_recycler, container,false) //Apunta al fragmento que tiene el recyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()//Aquí abriría otro thread?
    }

    fun setListener(l: (ProductoApi) ->Unit){
        listener = l
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView() {
        var listStr = this.arguments?.getString(SHOP_LIST)
        val listProductType = object : TypeToken<MutableList<ProductoApi>>(){}.type
        val prods = Gson().fromJson<MutableList<ProductoApi>>(MainApp.array, listProductType)
        //Log.d("setUpRecycler", prods.toString())
        recyclerProducts.setHasFixedSize(true)
        recyclerProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapter(requireActivity(), prods, listener)
        //asignando el Adapter al RecyclerView
        recyclerProducts.adapter = mAdapter
    }
}




