package androidluckyguys.org.kotlinsample

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class ExplicitIntentActivity : AppCompatActivity() , View.OnClickListener {



    var intentButton : Button? = null
    var myeditInputField : EditText? = null
    var editFieldValue : String? = null
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)
        /* set title bar text*/
        toolbar = findViewById<Toolbar>(R.id.myToolbar)

        setSupportActionBar(toolbar)
        this.supportActionBar!!.setTitle("First Activity")
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        intentButton = findViewById<Button>(R.id.myIntentButton)

        intentButton = findViewById<Button>(R.id.myIntentButton)
        intentButton?.setOnClickListener(this)

        myeditInputField= findViewById<EditText>(R.id.myInputField)
    }


    /*button click listener interface method implementation*/
    override fun onClick(v: View?) {

        when(v?.id)
        {
            R.id.myIntentButton->{
                val  intent: Intent = Intent(this,ExplicitIntentSecondActivity::class.java)
                editFieldValue = myeditInputField!!.text.toString()

                intent.putExtra("data", editFieldValue)
                var b = Bundle()
                b.putBoolean("hasData", true)
                intent.putExtras(b)
                startActivity(intent)
                finish()
            }
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
