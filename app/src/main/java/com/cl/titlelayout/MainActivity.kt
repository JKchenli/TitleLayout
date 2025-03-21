package com.cl.titlelayout

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cl.titlelayout.databinding.ActivityMainBinding
import com.cl.titlelayout.widget.TitleLayoutConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        with(bind) {
            btSingleLeft.setOnClickListener {
                val intent = Intent(this@MainActivity, SingleLeftActivity::class.java)
                startActivity(intent)
            }
            btSingleLeftRight.setOnClickListener {
                val intent = Intent(this@MainActivity, SingleRightLeftActivity::class.java)
                startActivity(intent)
            }
            btMultipleRight.setOnClickListener {
                val intent = Intent(this@MainActivity, MultipleRightActivity::class.java)
                startActivity(intent)
            }
            btLeftRightText.setOnClickListener {
                val intent = Intent(this@MainActivity, RightLeftTextActivity::class.java)
                startActivity(intent)
            }
            btConfigReduction.setOnClickListener {
                TitleLayoutConfig.reductionConfig()
            }
            btConfigSave.setOnClickListener {
                var titleSize = 18
                var operationSize = 14
                try {
                    titleSize = etTitleSize.text.toString().toInt()
                    operationSize = etOperationSize.text.toString().toInt()
                } catch (e: Exception) {
                }
                val color = if (rbBlack.isChecked) {
                    Color.BLACK
                } else {
                    Color.RED
                }
                val style = if (rbNormal.isChecked) {
                    Typeface.NORMAL
                } else if (rbBold.isChecked) {
                    Typeface.BOLD
                } else if (rbItalic.isChecked) {
                    Typeface.ITALIC
                } else {
                    Typeface.BOLD_ITALIC
                }
                TitleLayoutConfig.initTitleConfig(color, titleSize, style)
                TitleLayoutConfig.initOperationConfig(color, operationSize, style)
            }
        }
    }
}
