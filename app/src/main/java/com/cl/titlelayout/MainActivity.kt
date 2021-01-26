package com.cl.titlelayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cl.titlelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            button.setOnClickListener {
                val intent = Intent(this@MainActivity, SingleLeftActivity::class.java)
                startActivity(intent)
            }
            button2.setOnClickListener {
                val intent = Intent(this@MainActivity, SingleRightLeftActivity::class.java)
                startActivity(intent)
            }
            button3.setOnClickListener {
                val intent = Intent(this@MainActivity, MultipleRightActivity::class.java)
                startActivity(intent)
            }
            button4.setOnClickListener {
                val intent = Intent(this@MainActivity, RightLeftTextActivity::class.java)
                startActivity(intent)
            }
        }
    }
}