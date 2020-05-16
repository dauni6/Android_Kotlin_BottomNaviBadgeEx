package com.dontsu.bottomnavibadgeex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var badgeCount = 0
    private var currentBottomMenuItem = 0
    private var badge: BadgeDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNV.itemIconTintList = null //null 해줘야 비로소 selector_.xml 이 작동함

        currentBottomMenuItem = bottomNV.menu.getItem(1).itemId

        bottomNV.setOnNavigationItemSelectedListener { menuItem: MenuItem ->

            when(menuItem.itemId) {
                R.id.action_people -> {
                    Snackbar.make(coordinator, "피플뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.action_chat -> {
                    /*val menuIdx = menuItem.itemId
                    var badge = bottomNV.getOrCreateBadge(menuIdx)
                    badge.isVisible = true
                    badge.number = 56*/
                    //currentMenuIdx = menuItem.itemId
                    Snackbar.make(coordinator, "챗뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.action_search -> {
                    Snackbar.make(coordinator, "검색뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    Snackbar.make(coordinator, "설정뷰", Snackbar.LENGTH_SHORT).show()
                    true
                }

            }
        }
    }

    fun onBadgeCountUp(v: View) {
        if (badge == null || badgeCount == 0) badge = bottomNV.getOrCreateBadge(currentBottomMenuItem)
        badgeCount++
        badge?.number = badgeCount .also { badge?.isVisible = badgeCount > 0 }
    }

    fun onBadgeCountDown(v: View) {
        if (badgeCount != 0) {
            badgeCount--
            badge?.number = badgeCount .also { badge?.isVisible = badgeCount > 0 }
        } else {
            bottomNV.removeBadge(currentBottomMenuItem)
        }
    }

}
