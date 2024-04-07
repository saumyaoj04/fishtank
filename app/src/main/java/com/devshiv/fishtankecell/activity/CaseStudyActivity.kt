package com.devshiv.fishtankecell.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.ActivityCaseStudyBinding
import com.devshiv.fishtankecell.model.CaseStudyData

class CaseStudyActivity : AppCompatActivity() {

    lateinit var binding: ActivityCaseStudyBinding
    var caseStudyData: CaseStudyData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCaseStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        caseStudyData = intent.getSerializableExtra("data") as CaseStudyData

        if (caseStudyData == null) {
            Toast.makeText(this, "Failed To Fetch Data", Toast.LENGTH_SHORT).show()
            finish()
        }

        Glide.with(this).load(caseStudyData!!.Banner)
            .apply(
                RequestOptions()
                    .centerInside()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .placeholder(R.color.lightOrange)
                    .format(DecodeFormat.PREFER_RGB_565)
            )
            .thumbnail(0.08f)
            .into(binding.image)

        binding.description.text = caseStudyData!!.Description

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })

    }
}