package com.example.treinobottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()//esconde a barra que vem por padrão no empity project
        }

        title = resources.getString(R.string.favorites)
        loadFragment(FavoriteFragment())

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    title = resources.getString(R.string.home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_favorites -> {
                    title = resources.getString(R.string.favorites)
                    loadFragment(FavoriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_search -> {
                    title = resources.getString(R.string.search)
                    loadFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }

    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}