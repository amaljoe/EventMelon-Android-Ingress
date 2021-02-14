package com.devex.eventmelon.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devex.eventmelon.R
import com.devex.eventmelon.model.Event
import com.devex.eventmelon.util.bindImage

class ItemAdapter(private val context: Context, var dataset: List<Event>, val eventItemClickListener: EventItemClickListener) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val eventname: TextView = view.findViewById(R.id.eventname_card_home)
        val participant: TextView = view.findViewById(R.id.participants_card_home)
        val date: TextView = view.findViewById(R.id.date_card_home)
        val hostName: TextView = view.findViewById(R.id.host_name)
        val image: ImageView = view.findViewById(R.id.image_card_home)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.eventname.text = item.name
        //holder.participant.text = item.name
        holder.hostName.text = item.host
        //holder.date.text = item.date
        bindImage(holder.image, item.imageUrl)

        holder.view.setOnClickListener {
            eventItemClickListener.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}

class EventItemClickListener(val clickListener: ((event: String) -> Unit)) {
    fun onClick(event: Event) = clickListener(event.id)
}