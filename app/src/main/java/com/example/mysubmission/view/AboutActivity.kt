package com.example.mysubmission.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mysubmission.R
import com.example.mysubmission.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "About Me"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setData()
    }

    @SuppressLint("DiscouragedApi")
    private fun setData() {
        val drawableResourceId: Int = this.resources.getIdentifier(
            "img", "drawable", this.packageName
        )

        binding.apply {
            Glide.with(this@AboutActivity)
                .load(drawableResourceId)
                .circleCrop()
                .into(imgDetail)
            txtName.text = "Achmad Ilham"
            txtEmail.text = "achmadilham07@gmail.com"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

}