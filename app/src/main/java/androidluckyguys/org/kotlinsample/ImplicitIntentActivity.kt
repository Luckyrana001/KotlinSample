package androidluckyguys.org.kotlinsample

import android.content.Intent
import android.drm.DrmStore
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ImplicitIntentActivity : AppCompatActivity(), View.OnClickListener {

    var intentButton : Button? = null
    var myeditInputField : EditText? = null
    var editFieldValue : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)


        intentButton = findViewById<Button>(R.id.myIntentButton)
        intentButton?.setOnClickListener(this)

        myeditInputField= findViewById<EditText>(R.id.myEditText)
        editFieldValue = myeditInputField!!.text.toString()
    }


    /* button click listener interface method implementation */
    override fun onClick(v: View?) {

        when(v?.id)
        {
            R.id.myIntentButton->{
                val  intent: Intent = Intent(Intent.ACTION_VIEW)
                var editTextValue : String = editFieldValue!!
                intent.setData(Uri.parse(editTextValue))
                startActivity(intent)
            }
        }
    }
}


