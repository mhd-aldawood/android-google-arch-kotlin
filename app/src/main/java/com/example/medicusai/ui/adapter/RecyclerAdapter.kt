package com.example.medicusai.ui.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.RecyclerView
import com.example.medicusai.databinding.ItemBinding
import com.example.medicusai.model.Biomarker
import com.example.medicusai.ui.interfaces.OnItemClickListener

class RecyclerAdapter(val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var biomarkers = mutableListOf<Biomarker>()

    fun setBiomarkerList(biomarkers: List<Biomarker>) {
        this.biomarkers = biomarkers.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val biomarker = biomarkers[position]


        holder.symbol.text = biomarker.symbol
        holder.symbol.setTextColor(Color.parseColor(biomarker.color.toString()))

        var drawable = holder.symbol.background as (GradientDrawable)
        drawable.mutate()
        drawable.setStroke(5, Color.parseColor(biomarker.color.toString()))
        var color="#80"+biomarker?.color.toString().split("#")[1]

        drawable.setColor(Color.parseColor(color))

        holder.date.text = biomarker.date
        holder.value_.text = biomarker.value
        holder.bind(biomarkers.get(position), onItemClickListener);
    }
     override fun getItemCount(): Int {
        return biomarkers.size
    }

    class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val date: TextView = binding.date
        val value_: TextView = binding.value
        val symbol: TextView = binding.symbol


        fun bind(biomarker: Biomarker, itemClickListener: OnItemClickListener) {

            itemView.setOnClickListener(View.OnClickListener {
                itemClickListener.onClick(biomarker)
            })
        }

    }
}


