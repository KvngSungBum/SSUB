package com.example.hci.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hci.data.mainData
import com.example.hci.databinding.MainListBinding

class MainPageAdapter(val data: ArrayList<mainData>) : RecyclerView.Adapter<MainPageAdapter.SettingViewHolder>() {
    interface OnItemClickListener{
        fun OnItemClick(holder: SettingViewHolder, view: View, data: mainData, position: Int)
    }
    var itemClickLister: OnItemClickListener?=null


    inner class SettingViewHolder (val binding :MainListBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.fromStation.setOnClickListener{
                itemClickLister?.OnItemClick(this,it,data[adapterPosition], adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val view = MainListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val item = data[position]
        holder.binding.fromStation.text = item.fromStation
        holder.binding.toStation.text = item.toStation
        holder.binding.firstTime.text = item.firstTime
        holder.binding.secondTime.text = item.secondTime
    }

    override fun getItemCount(): Int = data.size
}