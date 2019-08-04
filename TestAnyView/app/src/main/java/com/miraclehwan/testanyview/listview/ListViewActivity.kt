package com.miraclehwan.testanyview.listview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.miraclehwan.testanyview.R
import kotlinx.android.synthetic.main.activity_listview.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        listview.adapter = ListAdapter().apply {
            listview.onItemClickListener = object : AdapterView.OnItemClickListener {
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    view?.isSelected = true
                }
            }
        }
    }
}