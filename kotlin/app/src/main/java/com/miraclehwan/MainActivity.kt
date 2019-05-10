package com.miraclehwan

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mBeforeText = "BEFORE"
    private val mAfterText = "AFTER"

    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContent.text = mBeforeText

        tvContent.setOnClickListener { tvContent.text = mAfterText }

        mHandler = Handler().also { handler ->
            handler.postDelayed({
                val intent = Intent(this, SubActivity::class.java)
                intent.putExtra("test", "메인에서 전달온 값")
                startActivity(intent)
                finish()
            }, 3000);
        }
    }
}
