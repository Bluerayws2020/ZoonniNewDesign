package com.blueray.zoonni.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.blueray.zoonni.databinding.SummerSaleItemBinding

class HomeSliderAdapter(
    // todo change the model
    var list : List<String>):RecyclerView.Adapter<HomeSliderAdapter.MyViewHolder>() {

        inner class MyViewHolder(val binding : SummerSaleItemBinding) :ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = SummerSaleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = 5


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // todo implementation
        holder.binding.apply {

        }
        holder.itemView.setOnClickListener {
            // todo change the click params
            onItemClick?.invoke("")
        }
    }
    private var onItemClick : ((id:String)->Unit)? = null
    fun onItemClickListener(listener : ((id:String)->Unit)){
        onItemClick = listener
    }
}