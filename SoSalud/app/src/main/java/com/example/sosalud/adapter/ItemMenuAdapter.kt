package com.example.sosalud.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.model.Services
import com.example.sosalud.view.MenuAct

class ItemMenuAdapter(
    private val context: MenuAct,
    private val dataset: List<Services>
): RecyclerView.Adapter<ItemMenuAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.medserviceName2)
        val imageView: ImageView = view.findViewById(R.id.item_image2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}