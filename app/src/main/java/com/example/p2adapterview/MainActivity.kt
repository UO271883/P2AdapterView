package com.example.p2adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val spinner: Spinner by lazy{
            findViewById(R.id.spinner)
        }
        val etiqueta: TextView by lazy{
            findViewById(R.id.etiqueta)
        }
        val adaptador = ArrayAdapter(
            this,
            R.layout.spinner_cerrado,
            R.id.text,
            resources.getStringArray(R.array.animales)
        )

        /*val adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.animales,
            android.R.layout.simple_spinner_item
        )*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adaptador.setDropDownViewResource(R.layout.spinner_dropdown)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccion: TextView? = view?.findViewById(R.id.text)
                etiqueta.text = seleccion?.text
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}