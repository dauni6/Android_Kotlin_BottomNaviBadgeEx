package com.dontsu.bottomnavibadgeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNV.itemIconTintList = null //null 해줘야 비로소 selector_.xml 이 작동함

        bottomNV.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when(menuItem.itemId) {
                R.id.action_people -> {
                    Snackbar.make(mainLayout, "피플뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.action_chat -> {
                    Snackbar.make(mainLayout, "챗뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.action_search -> {
                    Snackbar.make(mainLayout, "검색뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Snackbar.make(mainLayout, "설정뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }

            }
        }
    }
}
