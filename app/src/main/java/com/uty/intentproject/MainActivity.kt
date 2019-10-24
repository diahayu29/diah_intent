@file:Suppress("DEPRECATION")

package com.uty.intentproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit_nim = findViewById<EditText>(R.id.edit_nim)
        val edit_nama = findViewById<EditText>(R.id.edit_nama)
        val edit_nilai = findViewById<EditText>(R.id.edit_nilai)
        val btn_proses = findViewById<Button>(R.id.btn_proses)


        btn_proses.setOnClickListener {
            if(edit_nim.text.isEmpty() || edit_nama.text.isEmpty() || edit_nilai.text.isEmpty()){
                  toast("Kolom tidak boleh kosong!!", Toast.LENGTH_LONG)
                } else if (edit_nim.text.isNotEmpty() || edit_nama.text.isNotEmpty() || edit_nilai.text.isNotEmpty()) {
                    toast( "Data Tersimpan", Toast.LENGTH_LONG)

                //get text from edittext
                val nim = edit_nim.text.toString()
                val nama = edit_nama.text.toString()
                val nilai = edit_nilai.text.toString()

                //intent
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("Nim", nim)
                intent.putExtra("Nama", nama)
                intent.putExtra("Nilai", nilai)
                startActivity(intent)
            }
        }
    }

    private fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()

    }
}