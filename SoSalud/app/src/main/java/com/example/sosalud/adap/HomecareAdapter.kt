package com.example.sosalud.adap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sosalud.R
import com.example.sosalud.adapter.ItemAdapter
import com.example.sosalud.model.Persons
import com.example.sosalud.view.HomecareActivity
import com.example.sosalud.view.MedServicesActivity

class HomecareAdapter(
    private val context: HomecareActivity,
    private val dataset: List<Persons>
): RecyclerView.Adapter<HomecareAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView = view.findViewById(R.id.HomecareserviceName)
        val textView2: TextView = view.findViewById(R.id.directionPatient)
        val textView3: TextView = view.findViewById(R.id.hourPatient)
        val imageView: ImageView = view.findViewById(R.id.HomecareservicePhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_homecare_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView1.text = context.resources.getString(item.stringResourceId)
        holder.textView2.text = context.resources.getString(item.stringResourceAddres)
        holder.textView3.text = context.resources.getString(item.stringResourceDate)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}