package androidluckyguys.org.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_button_click_demo.*
import kotlinx.android.synthetic.main.activity_main.*



class ButtonClickDemoActivity : AppCompatActivity() {


    var floatingBtn:FloatingActionButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click_demo)

        /*set text to TextView dynamically */
        bottomTextView.text = "Hi this is bottom TextView";


        /* get resource string and set to textview*/
        var appName = this.getString(R.string.app_name);
        centerTextView.text = appName




        floatingBtn = findViewById<FloatingActionButton>(R.id.fab)


        /*calling another method showSnackBar and pass parameter view in it*/
        floatingBtn?.setOnClickListener { view ->
            showSnackBar(view)
        }


            /*button click event demonstration:
                no need to intialize button variable, you can directly add click listener and use it
                But */

            myButton.setOnClickListener({

                Toast.makeText(this, "hi this is simple toast message", Toast.LENGTH_LONG).show()
            })


            /* passing EditText value to button click listener*/

            myButton1.setOnClickListener({
                if (myEditText.text.length>0) {
                    Toast.makeText(this, myEditText.text, Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, "Please type some text in input field", Toast.LENGTH_LONG).show()

                }
            })
        }


    fun showSnackBar(view: View)
    {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }
}
