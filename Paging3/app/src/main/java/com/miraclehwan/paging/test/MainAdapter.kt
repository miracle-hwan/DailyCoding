package com.miraclehwan.paging.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.miraclehwan.paging.databinding.ItemListBinding
import com.miraclehwan.paging.test.response.Data

class MainAdapter : PagingDataAdapter<Data, MainAdapter.ListHolder>(
    DataDifferntiator
) {

    object DataDifferntiator : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }


    class ListHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {
            binding.tvName.text =
                "${item.firstName} ${item.lastName}"
            binding.tvEmail.text = item.email
        }
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}