package com.blueray.zoonni.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blueray.zoonni.databinding.ProductsItemBinding

class LatestProductAdapter(
    // todo change the model
    var list : List<String>): RecyclerView.Adapter<LatestProductAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : ProductsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ProductsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = 20


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