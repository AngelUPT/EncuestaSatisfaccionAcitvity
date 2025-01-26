package com.angelcorrea.encuestasatisfaccionactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtComentarios = findViewById<EditText>(R.id.edtComentarios)
        val seekBarSatisfaccion = findViewById<SeekBar>(R.id.seekBarSatisfaccion)
        val txtValorSatisfaccion = findViewById<TextView>(R.id.txtValorSatisfaccion)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        seekBarSatisfaccion.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtValorSatisfaccion.text = "Valor: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnEnviar.setOnClickListener {
            val nombre = edtNombre.text.toString()
            val comentarios = edtComentarios.text.toString()
            val satisfaccion = seekBarSatisfaccion.progress

            if (nombre.isNotEmpty() && comentarios.isNotEmpty()) {
                val message = "Nombre: $nombre\n" +
                        "Nivel de Satisfacción: $satisfaccion\n" +
                        "Comentarios: $comentarios"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}