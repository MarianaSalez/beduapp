package org.bedu.bedushop

import RecyclerAdapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_listado.*
import kotlinx.android.synthetic.main.fragment_listado.*
import kotlinx.android.synthetic.main.fragment_recycler.*
import java.io.IOException


class ListadoFragment : Fragment() {

    private lateinit var mAdapter: RecyclerAdapter
    private lateinit var products: List<Product>

    private var listener: (Product) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val realm = Realm.getDefaultInstance()
        products = realm.where(Product::class.java).findAll()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout de fragment
        return inflater.inflate(
            R.layout.fragment_recycler,
            container,
            false
        ) //Apunta al fragmento que tiene el recyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Product) -> Unit) {
        listener = l

    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView() {
        recyclerProducts.setHasFixedSize(true)
        recyclerProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapter(requireActivity(), products as MutableList<Product>, listener)
        //asignando el Adapter al RecyclerView
        recyclerProducts.adapter = mAdapter
    }

    /*   private fun getJsonDataFromAsset(context: Context, fileName: String = "products.json"): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getProducts(context: Context): MutableList<Product>{
        val jsonString = getJsonDataFromAsset(context)
        val listProductType = object : TypeToken<MutableList<Product>>(){}.type
        return Gson().fromJson(jsonString, listProductType)
    }
}*/
}




