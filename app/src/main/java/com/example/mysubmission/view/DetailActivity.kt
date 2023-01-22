package com.example.mysubmission.view

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mysubmission.data.Restaurant
import com.example.mysubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val RESTAURANT_DATA = "restaurant_data"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Restaurant Detail"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val restaurant: Restaurant? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(RESTAURANT_DATA, Restaurant::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(RESTAURANT_DATA)
        }

        setData(restaurant)
    }

    private fun setData(restaurant: Restaurant?) {
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(restaurant?.getPicture())
                .into(img)
            txtTitle.text = restaurant?.name
            txtDescription.text = restaurant?.description
            txtCity.text = restaurant?.city
            txtRating.text = restaurant?.rating.toString()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}