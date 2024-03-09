package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecyclerRowBinding

class Adapter(val ds: MutableList<User>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(val binding: RecyclerRowBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           with(holder.binding){
               name.text = ds.get(position).name
               age.text = ds.get(position).age.toString()
           }
    }
}