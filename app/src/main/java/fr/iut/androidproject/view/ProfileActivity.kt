package fr.iut.androidproject.view

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.squareup.picasso.Picasso
import fr.iut.androidproject.R
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        imageView = findViewById<ImageView>(R.id.profile_image)

        val userFullname = intent.getStringExtra("USER_FULLNAME")
        val userUsername = intent.getStringExtra("USER_USERNAME")
        val userPassword = intent.getStringExtra("USER_PASSWORD")

        val fullnameTextView = findViewById<TextView>(R.id.fullnameTextView)
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)

        fullnameTextView.text = "Full Name: $userFullname"
        usernameTextView.text = "Username: $userUsername"
        passwordTextView.text = "Password: $userPassword"

        takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                saveImageToGallery(photoFile.absolutePath)
            }
        }
    }

    private val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var photoFile: File
    private lateinit var photoURI: Uri
    private lateinit var imageView: ImageView

    private lateinit var takePictureLauncher: ActivityResultLauncher<Intent>

    fun takePhoto(view: View) {
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_IMAGE_CAPTURE
            )
        } else {
            dispatchTakePictureIntent()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_IMAGE_CAPTURE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                photoFile = createImageFile()
                photoFile.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "fr.iut.androidproject.fileprovider",
                        it
                    )
                    this.photoURI = photoURI
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    takePictureLauncher.launch(takePictureIntent)
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            val savedImagePath = absolutePath
            imageView.setImageBitmap(BitmapFactory.decodeFile(savedImagePath))
        }
    }

    private fun saveImageToGallery(savedImagePath: String) {
        val photoFile = File(savedImagePath)
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, photoFile.name)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
        }
        val externalUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val contentResolver = applicationContext.contentResolver

        val uri = contentResolver.insert(externalUri, values)

        Picasso.get()
            .load(uri)
            .into(imageView)
        imageView.setImageBitmap(BitmapFactory.decodeFile(savedImagePath))
    }
}