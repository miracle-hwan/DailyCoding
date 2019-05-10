package com.miraclehwan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(val mContext: Context, var mPersonList: List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    override fun getItemCount(): Int {
        return mPersonList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.onBind(mPersonList.get(position))
    }


    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(person: Person){
            itemView?.findViewById<TextView>(R.id.tv_name).also { it.text = person.name }
            itemView?.findViewById<TextView>(R.id.tv_age).also { it.text = person.age.toString() }
        }
    }
}