package org.bedu.bedushop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import org.bedu.bedushop.Product

class DetailActivity : AppCompatActivity() {
    companion object {
        val PRODUCT = "PRODUCT"
    }
    private lateinit var addBoton: Button
    private  var carritoFragment= CarritoFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getParcelableExtra<Product>(PRODUCT)
        val detailFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? DetailFragment
        if (product != null) {
            detailFragment?.showProduct(product)

        }

        addBoton = findViewById(R.id.addCarrito)
        addBoton.setOnClickListener{
            val intent= Intent(this, Shop::class.java).apply {  }

            //DATOS EXTRA
            intent.putExtra("origen", "DETAIL");

            startActivity(intent)

        }

    }
}