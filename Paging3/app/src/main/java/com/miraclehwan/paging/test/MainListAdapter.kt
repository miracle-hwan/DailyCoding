package com.miraclehwan.paging.test

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.miraclehwan.paging.R
import com.miraclehwan.paging.test.response.Data

class MainListAdapter : PagingDataAdapter<Data, MainListAdapter.ViewHolder>(
    DataDifferntiator
) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemView.textViewName.text =
//            "${getItem(position)?.firstName} ${getItem(position)?.lastName}"
//        holder.itemView.textViewEmail.text = getItem(position)?.email
        Log.e("daehwan", "${position}")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.list_item,
                    parent,
                    false
                )
        )
    }

    object DataDifferntiator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

}
