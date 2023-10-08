package com.blueray.zoonni.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blueray.zoonni.R
import com.blueray.zoonni.databinding.CategoryItemBinding

class CategoriesAdapter(
    // todo change the model
    var list : List<String>): RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = 20


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // todo implementation
        holder.apply {
            if(position%2 == 0){
              binding.cateImage.setImageResource(R.drawable.logo)
            }
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