package com.example.journeytoandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*


class AdapterEventAboutMe(
    var events: List<EventAboutMe>
) : RecyclerView.Adapter<AdapterEventAboutMe.EventViewHolder>() {

    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return EventViewHolder(view)

    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.itemView.apply{
            cbDone.isChecked = events[position].isDone
            tvEvent.text = events[position].event
        }
    }
}