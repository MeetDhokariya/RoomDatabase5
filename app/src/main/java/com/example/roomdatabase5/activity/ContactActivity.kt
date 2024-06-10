package com.example.roomdatabase5.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomdatabase5.R
import com.example.roomdatabase5.databinding.ActivityContactBinding
import com.example.roomdatabase5.db.ContactEntity
import com.example.roomdatabase5.db.DBHelper

class ContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val db = DBHelper.checkDB(this)
        binding.btnSave.setOnClickListener {

            val name = binding.edtname.text.toString()
            val phone = binding.edtphone.text.toString()
            val email = binding.edtemail.text.toString()

            val model = ContactEntity(name = name, phone = phone, email = email)
            db.dao().insertContact(model)
            finish()
        }

    }
}