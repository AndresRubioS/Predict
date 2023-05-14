package com.example.predict.ui.NavBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.predict.R
import com.example.predict.databinding.ActivityBottomNavigationBinding
import com.example.predict.ui.NavBar.Home.HomeFragment
import com.example.predict.ui.NavBar.predict.PredictFragment

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
                R.id.noticias -> replaceFragment(NoticiasFragment())
                R.id.predict -> replaceFragment(PredictFragment())
                R.id.promos -> replaceFragment(PromosFragment())
                R.id.ranking -> replaceFragment(RankingFragment())

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