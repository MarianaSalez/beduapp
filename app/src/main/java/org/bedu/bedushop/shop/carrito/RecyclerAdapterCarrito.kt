package org.bedu.bedushop.shop.carrito

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.bedu.bedushop.Producto.MainApp
import org.bedu.bedushop.Producto.ProductoApi
import org.bedu.bedushop.R

class RecyclerAdapterCarrito (private val context: Context,
                              private var products: MutableList<ProductoApi>): RecyclerView.Adapter<RecyclerAdapterCarrito.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val title = view.findViewById<TextView>(R.id.titleCarrito)
        private val price = view.findViewById<TextView>(R.id.priceCarrito)
        private val image = view.findViewById<ImageView>(
            R.id.carritoImageView
        )
        private val stock = view.findViewById<TextView>(R.id.cantidad)
        private val sumar = view.findViewById<ImageButton>(R.id.sumar)
        private val restar = view.findViewById<ImageButton>(R.id.restar)


        fun bind(product : ProductoApi, context: Context){
            title.text = product.title
            Picasso.with(context).load(product.image).into(image)
            price.text = product.price.toString()
            stock.text = product.stock.toString()
            sumar.setOnClickListener{
                product.stock++
                stock.text = product.stock.toString()
            }
            restar.setOnClickListener {
                product.stock--
                if(product.stock <= 0){
                    MainApp.listaCarritoHolder?.remove(product)
                    MainApp.listaCarritoHolderId?.remove(product.id)
                }
                stock.text = product.stock.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.carrito_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products?.get(position)
        if (product != null) {
            holder.bind(product, context)
        }
    }

    override fun getItemCount(): Int {

        return products.size
    }

}