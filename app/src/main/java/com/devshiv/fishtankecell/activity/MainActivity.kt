package com.devshiv.fishtankecell.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.devshiv.fishtankecell.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
//        recyclerView=findViewById(R.id.recyclerView)
    }
}