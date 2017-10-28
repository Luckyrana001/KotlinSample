package androidluckyguys.org.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ToolbarMenuHandlingActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_menu_handling)


        /* set title bar text*/
        toolbar = findViewById<Toolbar>(R.id.toolbarMenu)

        setSupportActionBar(toolbar)
        this.supportActionBar!!.setTitle("Menu Handling Sample")
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true);




    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


       if (id == android.R.id.home) {
           Toast.makeText(this, "Back Button clicked", Toast.LENGTH_LONG).show()

           finish()

           true
       }
        else if(id == R.id.miCompose) {
           Toast.makeText(this, "Home Button clicked", Toast.LENGTH_LONG).show()

           true
       }
       else if(id == R.id.miSearch) {
           Toast.makeText(this, "Search Button clicked", Toast.LENGTH_LONG).show()
           true
       }


        return super.onOptionsItemSelected(item)
    }
}
