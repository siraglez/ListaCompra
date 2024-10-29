package com.example.listacompra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ProductAdapter(context: Context, products: List<Product>) :
    ArrayAdapter<Product>(context, 0, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            android.R.layout.simple_list_item_1, parent, false
        )

        // Obtenemos el producto en la posición actual
        val product = getItem(position)

        // Formateamos el texto para mostrar como "Producto (Cantidad) = Precio€"
        val displayText = buildString {
            append(product?.name ?: "")
            if (!product?.quantity.isNullOrEmpty()) append(" (${product?.quantity})")
            if (!product?.price.isNullOrEmpty()) append(" = ${product?.price}€")
        }

        // Configuramos el TextView para mostrar el texto
        view.findViewById<TextView>(android.R.id.text1).text = displayText

        return view
    }
}