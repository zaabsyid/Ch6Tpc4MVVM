package com.zahirar.ch6tpc4mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zahirar.ch6tpc4mvvm.databinding.ItemCarBinding
import com.zahirar.ch6tpc4mvvm.model.GetCarResponseItem

class CarAdapter(var listCar : List<GetCarResponseItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.binding.txtName.text = listCar[position].name
        holder.binding.txtCategory.text = listCar[position].category
        holder.binding.txtPrice.text = listCar[position].price.toString()
        holder.binding.txtImg.text = listCar[position].image
        Glide.with(holder.itemView).load(listCar[position].image).into(holder.binding.imgCar)
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}