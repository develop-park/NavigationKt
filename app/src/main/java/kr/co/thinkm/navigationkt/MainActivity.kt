package kr.co.thinkm.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_navi = findViewById<ImageView>(R.id.btn_navi)
        btn_navi.setOnClickListener {
            val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
            layout_drawer.openDrawer(GravityCompat.START)
        }

        val naviView = findViewById<NavigationView>(R.id.naviView)
        naviView.setNavigationItemSelectedListener(this)


        // 공부중2.....
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
        }

        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
        layout_drawer.closeDrawers()

        return false
    }

    override fun onBackPressed() {
        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)

        if(layout_drawer.isDrawerOpen(GravityCompat.START)) {
            layout_drawer.close()
            return
        }

        super.onBackPressed()
    }
}