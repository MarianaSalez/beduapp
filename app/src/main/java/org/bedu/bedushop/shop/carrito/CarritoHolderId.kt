package org.bedu.bedushop.shop.carrito

class CarritoHolderId private constructor() {
    val listaCarritoId: MutableList<Int> = mutableListOf()

    companion object {
        var instance: CarritoHolderId? = null
            get() {
                if (field == null) {
                    field = CarritoHolderId()
                }
                return field
            }
            private set
    }
}