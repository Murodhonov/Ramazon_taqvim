package uz.umarxon.ramazon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.nitish.typewriterview.TypeWriterView
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val bMenu = findViewById<AnimatedBottomBar>(R.id.animatedBottom)
        window.navigationBarColor = resources.getColor(R.color.purple_700)

        Constants.title.observeForever {
            val text = findViewById<TypeWriterView>(R.id.header_title)
            text.setCharacterDelay(40)
            text.avoidTextOverflowAtEdge(true)
            if (text.isAnimationRunning) {
                text.stopAnimation()
                text.animateText(it)
            }else{
                text.animateText(it)
            }
        }

        viewPager.adapter = ViewPagerAdapter1(supportFragmentManager, lifecycle)
        viewPager.currentItem = 1

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bMenu.selectTabAt(position)
                Constants.player2.stop()
                Constants.player.stop()
                Constants.pause_all.value = true
                Constants.title.value = bMenu.selectedTab!!.title
            }
        })

        bMenu.selectTabAt(1)

        bMenu.onTabSelected = {
            Log.d("bottom_bar", "Selected tab: " + it.title)
            viewPager.currentItem = bMenu.selectedIndex
        }
    }

    override fun onStart() {
        super.onStart()
        if (Constants.isFirst) startActivity(Intent(this, MyCustomSplash::class.java))
    }

    override fun onBackPressed() {
        Constants.player.stop()
        Constants.player2.stop()
        if (findViewById<ViewPager2>(R.id.view_pager).currentItem==1){
            finishAffinity()
        }else{
            findViewById<ViewPager2>(R.id.view_pager).currentItem = 1
        }
    }

}