package androidluckyguys.org.kotlinsample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import com.example.admin.recyclerviewkotlin.RecylerViewDemo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   var toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* set title bar text*/

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        this.supportActionBar!!.setTitle("Simple Kotlin Tricks")

        /* click listener method*/
        recylerViewSample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,RecylerViewDemo::class.java)
                    startActivity(intent)
                }
        )



        buttonClickSample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,ButtonClickDemoActivity::class.java)
                    startActivity(intent)
                }
        )


        explicitIntentSample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,ExplicitIntentActivity::class.java)
                    startActivity(intent)
                }
        )


        implicitIntentSample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,ImplicitIntentActivity::class.java)
                    startActivity(intent)
                }
        )

        toolbarMenuIntentSample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,ToolbarMenuHandlingActivity::class.java)
                    startActivity(intent)
                }
        )


        imageCaputreAndGallerySample.setOnClickListener(
                {
                    val  intent: Intent = Intent(this,CameraAndGalleryIntentSample::class.java)
                    startActivity(intent)
                }
        )



    }



}
