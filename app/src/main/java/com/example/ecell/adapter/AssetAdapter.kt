package com.example.ecell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecell.databinding.DashitemBinding

class AssetAdapter (private val assets:List<String>,private val image:List<Int>,private val price:List<String>, private val inc:List<String>): RecyclerView.Adapter<AssetAdapter.AssetViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(DashitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val asset =assets[position]
        val images= image[position]
        val prices= price[position]
        val incs= inc[position]
        holder.bind(asset,images,prices,incs)
    }
    override fun getItemCount(): Int {
        return assets.size
    }
    class AssetViewHolder(private val binding:DashitemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imagesView=binding.assetImage
        fun bind(asset: String, images: Int, prices: String, incs: String) {
            binding.assetName.text=asset
            binding.marketValue.text=prices
            binding.percInc.text=incs
            imagesView.setImageResource(images)


        }

    }



    }




