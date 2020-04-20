package com.miracle.testmvvm.beta

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miracle.testmvvm.R

class BetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_beta)

        Toast.makeText(this, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()
    }
}