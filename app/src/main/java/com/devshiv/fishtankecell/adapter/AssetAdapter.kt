package com.devshiv.fishtankecell.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.LayoutAssetsItemBinding
import com.devshiv.fishtankecell.model.AssetsData

class AssetAdapter(
    private val assets: ArrayList<AssetsData>,
    private val context: Activity,
) : RecyclerView.Adapter<AssetAdapter.AssetViewHolder>() {

    private var colors = mutableListOf<Int>(
        R.color.lightOrange,
        R.color.lightBlue,
        R.color.lightPurple
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            LayoutAssetsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val data = assets[position]

        val color = colors[position % colors.size] // Cycle through colors using modulo operator
        holder.binding.container.setBackgroundResource(color)

        // Darken the color to use as background for another layout within the item
        val darkenedColor = ColorUtils.blendARGB(
            ContextCompat.getColor(holder.itemView.context, color),
            ContextCompat.getColor(holder.itemView.context, R.color.black), 0.05f
        )
        holder.binding.image.setBackgroundColor(darkenedColor)

        Glide.with(context).load(data.Image)
            .apply(
                RequestOptions()
                    .centerInside()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .placeholder(R.color.lightOrange)
                    .format(DecodeFormat.PREFER_RGB_565)
            )
            .thumbnail(0.08f)
            .into(holder.binding.image)

        holder.binding.title.text = data.Name
        holder.binding.price.text = "$${data.Price}"
    }

    override fun getItemCount(): Int {
        return assets.size
    }

    class AssetViewHolder(private val view: LayoutAssetsItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        var binding = view
    }

}




