package com.cl.titlelayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cl.titlelayout.databinding.ActivityMainBinding
import com.cl.titlelayout.databinding.ActivityMultipleRightBinding

class MultipleRightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMultipleRightBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            tlTitle.getLeftView1()?.setOnClickListener {
                finish()
                Toast.makeText(this@MultipleRightActivity, "点击Left", Toast.LENGTH_SHORT).show()
            }
            tlTitle.getRightView1()?.apply {
                setBackgroundColor(Color.YELLOW)//演示点击区域
                setOnClickListener {
                    Toast.makeText(this@MultipleRightActivity, "点击Right1", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            tlTitle.getRightView2()?.apply {
                setBackgroundColor(Color.RED)//演示点击区域
                setOnClickListener {
                    Toast.makeText(this@MultipleRightActivity, "点击Right2", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}