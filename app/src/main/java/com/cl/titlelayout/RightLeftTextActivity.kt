package com.cl.titlelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cl.titlelayout.databinding.ActivityMultipleRightBinding
import com.cl.titlelayout.databinding.ActivityRightLeftTextBinding

class RightLeftTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityRightLeftTextBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            tlTitle.leftView[1].getContent()?.setOnClickListener {
                finish()
                Toast.makeText(this@RightLeftTextActivity, "点击Left", Toast.LENGTH_SHORT).show()
            }
            tlTitle.rightView[1].getContent()?.setOnClickListener {
                Toast.makeText(this@RightLeftTextActivity, "点击Right", Toast.LENGTH_SHORT).show()
            }
        }
    }
}