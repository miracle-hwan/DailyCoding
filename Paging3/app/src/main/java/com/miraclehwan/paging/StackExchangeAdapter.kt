package com.miraclehwan.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miraclehwan.paging.databinding.ItemStackExchangeBinding
import com.miraclehwan.paging.response.Item

class StackExchangeAdapter :
    PagingDataAdapter<Item, StackExchangeAdapter.ItemViewHolder>(ItemDifferntiator) {

    object ItemDifferntiator : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.answerId == newItem.answerId
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    class ItemViewHolder(val binding: ItemStackExchangeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            Glide.with(binding.ivProfile)
                .load(item.owner.profileImage)
                .into(binding.ivProfile)
            binding.tvName.text = item.owner.displayName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemStackExchangeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        getItem(position)?.run {
            holder.bind(this)
        }
    }
}