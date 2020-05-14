package com.duyi.webviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt_web.setOnClickListener {
            startWebActivity(this, "https://www.baidu.com/")
        }

        bt_normal_webview.setOnClickListener {
            val intent = Intent(this, NormalWebActivity::class.java)
            startActivity(intent)
        }
        bt_video_web.setOnClickListener {
            startVideoWebActivity(this)
        }
    }
}
