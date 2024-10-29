package com.example.listacompra

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listViewProducts: ListView
    private lateinit var editTextProductName: EditText
    private lateinit var editTextQuantity: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var buttonAdd: Button
    private lateinit var textViewTotalItems: TextView
    private lateinit var textViewTotalPrice: TextView

    private val products = mutableListOf<Product>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewProducts = findViewById(R.id.listViewProducts)
        editTextProductName = findViewById(R.id.editTextProductName)
        editTextQuantity = findViewById(R.id.editTextQuantity)
        editTextPrice = findViewById(R.id.editTextPrice)
        buttonAdd = findViewById(R.id.buttonAdd)
        textViewTotalItems = findViewById(R.id.textViewTotalItems)
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice)

        productAdapter = ProductAdapter(this, products)
        listViewProducts.adapter = productAdapter

        buttonAdd.setOnClickListener {
            addProduct()
        }

        // Inicializar valores de totales al abrir la app
        updateTotals()
    }

    private fun addProduct() {
        val productName = editTextProductName.text.toString().trim()
        val quantity = editTextQuantity.text.toString().trim()
        val price = editTextPrice.text.toString().trim()

        if (productName.isNotEmpty()) {
            val product = Product(name = productName, quantity = quantity, price = price)
            products.add(product)
            productAdapter.notifyDataSetChanged()
            updateTotals()

            // Limpiar los campos después de agregar
            editTextProductName.text.clear()
            editTextQuantity.text.clear()
            editTextPrice.text.clear()
        }
    }

    private fun updateTotals() {
        val totalItems = products.size
        val totalPrice = products.sumOf {
            try {
                it.price?.toDouble() ?: 0.0
            } catch (e: NumberFormatException) {
                0.0
            }
        }

        textViewTotalItems.text = getString(R.string.total_items, totalItems)
        textViewTotalPrice.text = getString(R.string.total_price, totalPrice)
    }
}
