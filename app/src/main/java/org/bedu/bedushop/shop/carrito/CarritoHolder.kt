package org.bedu.bedushop.shop.carrito

import org.bedu.bedushop.Producto.ProductoApi

class CarritoHolder private constructor() {
    val listaCarrito: MutableList<ProductoApi> = mutableListOf()

    companion object {
        var instance: CarritoHolder? = null
            get() {
                if (field == null) {
                    field = CarritoHolder()
                }
                return field
            }
            private set
    }
}