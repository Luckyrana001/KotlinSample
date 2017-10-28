package com.example.admin.recyclerviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidluckyguys.org.kotlinsample.R
import kotlinx.android.synthetic.main.activity_button_click_demo.*
import android.R.menu
import android.view.Menu


class RecylerViewDemo : AppCompatActivity() {
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recylerview_layout)


        toolbar = findViewById<Toolbar>(R.id.recylerViewToolbar)
        setSupportActionBar(toolbar)
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        this.supportActionBar!!.setTitle("Recyler View Sample")


        //Bind the recyclerview
        val recyclerView = findViewById<RecyclerView>(R.id.rvAndroidVersions)

        //Add a LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.addItemDecoration(LinearLayoutSpaceItemDecoration(16))

        //Here we create an arraylist to store alMyAndroidOS using the data class MyAndroidOS
        val alMyAndroidOS = ArrayList<MyAndroidOS>()

        //Adding some data to the arraylist
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Cupcake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Donut", "v1.6"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Eclair", "v2.1"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Froyo", "v2.2.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Gingerbread", "v2.3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Honeycomb", "v3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Ice Cream Sandwich", "v4.0.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Jelly Bean", "v4.1.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"KitKat", "v4.4.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Lollipop", "v5.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Marshmallow", "v6.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.ic_launcher_background,"Nougat", "v7.0"))

        // adding the adapter to recyclerView
        recyclerView.adapter = MyAndroidAdapter(alMyAndroidOS){

            Toast.makeText(this, "${it.name} Clicked", Toast.LENGTH_LONG).show()

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
       // menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == android.R.id.home) {
            finish()
            true
        } else super.onOptionsItemSelected(item)

    }

}
