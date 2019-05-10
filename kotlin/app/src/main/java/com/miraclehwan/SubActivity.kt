package com.miraclehwan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity(){

    private var mPersonList : ArrayList<Person> = ArrayList()
    private lateinit var mPersonAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        tv_content.text = intent.getStringExtra("test")

        for (age in 20..30){
            mPersonList.add(Person("이름 {$age}", age))
        }

        mPersonAdapter = PersonAdapter(this, mPersonList)

        rv_temp.layoutManager = LinearLayoutManager(this)
        rv_temp.adapter = mPersonAdapter
    }
}
