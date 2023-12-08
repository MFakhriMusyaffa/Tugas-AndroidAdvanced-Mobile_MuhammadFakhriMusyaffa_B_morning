package com.mobile.tugas_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobile.tugas_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment()).run {
            setTitles("Home","","")
        }

        binding.bottomNav.setOnNavigationItemSelectedListener { item->
            when (item.itemId){
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    setTitles("Beranda","","")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_chat -> {
                    loadFragment(ChatFragment())
                    setTitles("","Chat","")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    setTitles("","","Profile")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment) // Replace with your fragment container ID
            .commit()
    }
    private fun setTitles(homeTitle: String, chatTitle: String, profileTitle: String) {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView.menu.findItem(R.id.nav_home).setTitle(homeTitle)
        bottomNavigationView.menu.findItem(R.id.nav_chat).setTitle(chatTitle)
        bottomNavigationView.menu.findItem(R.id.nav_profile).setTitle(profileTitle)
    }
}