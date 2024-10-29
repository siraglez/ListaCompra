package com.example.listacompra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ProductAdapter(context: Context, private val products: List<Product>) :
    ArrayAdapter<Product>(context, 0, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val product = getItem(position)!!

        // Verifica si se reutiliza una vista existente, de lo contrario, infla una nueva
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)

        // Configura el texto del TextView
        val textViewProduct: TextView = view.findViewById(R.id.textViewProduct)
        textViewProduct.text = "\"${product.name}\": \"${product.quantity}\" = \"${product.price}\""

        return view
    }
}
