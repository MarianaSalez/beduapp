package org.bedu.bedushop

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.json.JSONArray
import org.json.JSONObject


class MainApp: Application() {
    override fun onCreate(){
        super.onCreate()
        Realm.init(this)


        //Aca Tengo que ver como es lo de networking que habua visto pablo

        val array= JSONArray(getJsonFile())

        val config =RealmConfiguration
        .Builder()
        .initialData{realm ->
            for (i in 0 until array.length()){
                //aca se setean los valores en Realm
                var rating = array.getJSONObject(i).getJSONObject("rating")

                val p= realm.createObject(Product::class.java, i)
                p.name = array.getJSONObject(i).getString("title")
                p.price = array.getJSONObject(i).getString("price").toFloat()
                p.description = array.getJSONObject(i).getString("description")
                p.category = array.getJSONObject(i).getString("category")
                p.rate = rating.getString("rate").toFloat()
                p.numOpinions = rating.getString("count")
                p.idImage = array.getJSONObject(i).getString("image")

            }}
            .deleteRealmIfMigrationNeeded()
            .name("realmDB.realm")
            .build()

        Realm.setDefaultConfiguration(config)
    }


//Esta funcion esta relacionada con obtener los datos para el val array
    fun getJsonFile():String{
        return applicationContext
            .assets
            .open("products.json").bufferedReader().use { it.readText() }
    }

}
