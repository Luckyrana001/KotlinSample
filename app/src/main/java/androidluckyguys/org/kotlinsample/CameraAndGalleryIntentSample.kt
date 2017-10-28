package androidluckyguys.org.kotlinsample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_camera_and_gallery_intent_sample.*
import java.io.FileNotFoundException


class CameraAndGalleryIntentSample : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var manualCaptureIv: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_and_gallery_intent_sample)
        /* set title bar text*/
        toolbar = findViewById<Toolbar>(R.id.cameraToolbar)

        setSupportActionBar(toolbar)
        this.supportActionBar!!.setTitle("Camera Sample")
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true);


        manualCaptureIv = findViewById<ImageView>(R.id.myImageView)

        captureImageButton.setOnClickListener(
                {
                    if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        //TO do here if permission is granted by user
                        takePhoto()
                    } else {
                        //ask for permission if user didnot given
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
                        }
                    }


                }
        )

        selectFromGalleryButton.setOnClickListener(
                {
                    selectImageInAlbum()
                }
        )

    }

    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }


    fun takePhoto() {
        val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent1.resolveActivity(packageManager) != null) {
            //intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
            startActivityForResult(intent1, REQUEST_TAKE_PHOTO)
        }


    }
    companion object {
        private val REQUEST_TAKE_PHOTO = 0
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }

    private val CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100

    var filePath: String? = null
    private var fileUri: Uri? = null // file url to store image/video

    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO)  {
            if (resultCode == RESULT_OK) {

                manualCaptureIv!!.setImageBitmap(data.extras.get("data")as Bitmap)

            }


            else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(applicationContext, "Canceled", Toast.LENGTH_SHORT).show()

            } else {

                // failed to capture image
                Toast.makeText(applicationContext,"Failed", Toast.LENGTH_SHORT).show()
            }
        }

        else if(requestCode == REQUEST_SELECT_IMAGE_IN_ALBUM)  {
            if (resultCode == RESULT_OK) {
                try {
                    val imageUri = data.data
                    val imageStream = contentResolver.openInputStream(imageUri)
                    val selectedImage = BitmapFactory.decodeStream(imageStream)
                    manualCaptureIv!!.setImageBitmap(selectedImage)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                }


            }


            else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(applicationContext, "Canceled", Toast.LENGTH_SHORT).show()

            } else {

                // failed to capture image
                Toast.makeText(applicationContext,"Failed", Toast.LENGTH_SHORT).show()
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
