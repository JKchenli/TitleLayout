package com.cl.titlelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cl.titlelayout.databinding.ActivitySingleLeftBinding

class SingleLeftActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivitySingleLeftBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            tlTitle.getLeftView1()?.setOnClickListener {
                finish()
                Toast.makeText(this@SingleLeftActivity, "点击Left", Toast.LENGTH_SHORT).show()
            }
        }
    }
}