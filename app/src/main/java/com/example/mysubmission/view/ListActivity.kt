package com.example.mysubmission.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysubmission.R
import com.example.mysubmission.adapter.ListAdapter
import com.example.mysubmission.data.Restaurant
import com.example.mysubmission.data.restaurantList
import com.example.mysubmission.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var rvRestaurant: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Restaurant List"

        rvRestaurant = findViewById(R.id.list_restaurant)
        rvRestaurant.setHasFixedSize(true)

        showRecyclerList()
    }


    private fun showRecyclerList() {
        rvRestaurant.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(restaurantList)
        rvRestaurant.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Restaurant) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(restaurant: Restaurant) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.RESTAURANT_DATA, restaurant)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}