package com.example.predict.ui.NavBar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.provider.ContactsContract.Settings
import androidx.fragment.app.Fragment
import com.example.predict.R
import com.example.predict.databinding.ActivityBottomNavigationBinding
import com.example.predict.databinding.FragmentHomeBinding

class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.btNavigation.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.settings -> replaceFragment(SettingFragment())

                else -> {

                }
            }
            true
        }






    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTRansition = fragmentManager.beginTransaction()
        fragmentTRansition.replace(R.id.frameLayout,fragment)
        fragmentTRansition.commit()

    }
}