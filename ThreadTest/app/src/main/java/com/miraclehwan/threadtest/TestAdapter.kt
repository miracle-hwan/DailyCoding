package com.miraclehwan.threadtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miraclehwan.threadtest.databinding.ItemTestBinding

class TestAdapter : RecyclerView.Adapter<TestAdapter.TestHolder>() {

    class TestHolder(val binding: ItemTestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bund(normalChannel: NormalChannel) {
            binding.tvTitle.text = normalChannel.title
        }
    }

    val itemList = mutableListOf<NormalChannel>()

    var onClickListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        return TestHolder(
            ItemTestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                onClickListener?.invoke()
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.bund(itemList[position])
    }
}