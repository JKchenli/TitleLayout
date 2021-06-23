package com.cl.titlelayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cl.titlelayout.databinding.ActivitySingleRightLeftBinding

class SingleRightLeftActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivitySingleRightLeftBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            tlTitle.leftView[1].getContent()?.setOnClickListener {
                finish()
                Toast.makeText(this@SingleRightLeftActivity, "点击Left", Toast.LENGTH_SHORT).show()
            }
            tlTitle.rightView[1].getContent()?.setOnClickListener {
                Toast.makeText(this@SingleRightLeftActivity, "点击Right", Toast.LENGTH_SHORT).show()
            }
        }
    }
}