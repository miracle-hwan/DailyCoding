package com.miraclehwan.testanyview.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.miraclehwan.testanyview.R

class ListAdapter : BaseAdapter() {

    var mItemList = mutableListOf("aa", "bb", "cc")
    lateinit var mViewHolder: ItemViewHolder

    override fun getItem(position: Int): Any {
        return mItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mItemList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_listview, null).apply {
            mViewHolder = ItemViewHolder().apply {
                mTextView = findViewById(R.id.tv_content)!!
            }
        }
        mViewHolder.mTextView.text = mItemList[position]
        return view!!;
    }

    inner class ItemViewHolder {
        lateinit var mTextView: TextView
    }
}