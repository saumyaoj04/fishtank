package com.devshiv.fishtankecell.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.LayoutOnboardItemBinding
import com.devshiv.fishtankecell.model.OnBoardData

class OnBoardVPAdapter(
    private val dataList: ArrayList<OnBoardData>,
    private val context: Activity
) : RecyclerView.Adapter<OnBoardVPAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutOnboardItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleTxt.text = dataList[position].headline
        holder.binding.descriptionTxt.text = dataList[position].description

        holder.binding.image.setImageDrawable(dataList[position].image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: LayoutOnboardItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }
}