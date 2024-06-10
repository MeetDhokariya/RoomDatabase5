package com.example.roomdatabase5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase5.activity.ContactActivity
import com.example.roomdatabase5.adapter.contactAdapter
import com.example.roomdatabase5.databinding.ActivityMainBinding
import com.example.roomdatabase5.db.ContactEntity
import com.example.roomdatabase5.db.DBHelper

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var contactList = listOf<ContactEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        var db = DBHelper.checkDB(this)
        contactList = db.dao().getAllContacts()


        val adapter = contactAdapter(contactList)
       // LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvdata.adapter = adapter
     //   binding.rvdata.layoutManager = layoutManager

        binding.fbAdd.setOnClickListener {

            var intent = Intent(this,ContactActivity::class.java)
            startActivity(intent)

        }
    }




}