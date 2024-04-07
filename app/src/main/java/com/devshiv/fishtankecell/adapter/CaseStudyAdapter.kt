package com.devshiv.fishtankecell.adapter

import android.app.Activity
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.LayoutCaseStudyItemBinding
import com.devshiv.fishtankecell.model.CaseStudyData
import com.devshiv.fishtankecell.utils.Variables.TAG
import java.util.Locale

class CaseStudyAdapter(
    private val assets: ArrayList<CaseStudyData>,
    private val context: Activity,
    private val callbacks: CaseStudyAdapter.Callbacks? = null,
) : RecyclerView.Adapter<CaseStudyAdapter.AssetViewHolder>() {
    private val timers = mutableMapOf<Int, CountDownTimer?>()

    interface Callbacks {
        fun onClicked(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val binding = LayoutCaseStudyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AssetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val data = assets[position]

        Glide.with(holder.itemView.context)
            .load(data.Banner)
            .apply(
                RequestOptions()
                    .centerInside()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .placeholder(R.color.lightOrange)
                    .format(DecodeFormat.PREFER_RGB_565)
            )
            .thumbnail(0.08f)
            .into(holder.binding.image)

        holder.binding.title.text = data.Title

        timers[position]?.cancel()

        Log.d(TAG, "onBindViewHolder: ${data.StartDate!!.toString()}")

        val startDate = data.StartDate?.toDate()?.time ?: 0
        if (startDate > 0) {
            timers[position] =
                object : CountDownTimer(startDate - System.currentTimeMillis(), 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val remainingTime = millisUntilFinished / 1000
                        val days = remainingTime / (24 * 60 * 60)
                        val hours = (remainingTime % (24 * 60 * 60)) / (60 * 60)
                        val minutes = (remainingTime % (60 * 60)) / 60
                        val seconds = remainingTime % 60

                        val countdownText = String.format(
                            Locale.getDefault(),
                            "%02d:%02d:%02d:%02d",
                            days,
                            hours,
                            minutes,
                            seconds
                        )
                        holder.binding.startDate.text = countdownText
                    }

                    override fun onFinish() {
                        holder.binding.startDate.text = "Expired" // Handle expiration
                    }
                }.start()
        } else {
            holder.binding.startDate.text = "Invalid Date" // Handle invalid date
        }

        holder.binding.container.setOnClickListener {
            callbacks?.onClicked(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return assets.size
    }

    class AssetViewHolder(val binding: LayoutCaseStudyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}




