package com.devshiv.fishtankecell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import carbon.view.View
import carbon.widget.Button
import carbon.widget.LinearLayout
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.adapter.OnBoardVPAdapter
import com.devshiv.fishtankecell.databinding.ActivityOnBoardBinding
import com.devshiv.fishtankecell.model.OnBoardData

class OnBoardActivity : AppCompatActivity() {

    lateinit var binding: ActivityOnBoardBinding
    var adapter: OnBoardVPAdapter? = null
    private var dataList = ArrayList<OnBoardData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList.add(
            OnBoardData(
                AppCompatResources.getDrawable(this, R.drawable.onboard1),
                "Unlock Value, Exchange Assets",
                "Revolutionize Your Investments with Our Exchanger App"
            )
        )
        dataList.add(
            OnBoardData(
                AppCompatResources.getDrawable(this, R.drawable.onboard2),
                "Maximize Returns",
                "Discover How Our Assets Exchanger App Turns Case Studies into Profitable Moves"
            )
        )
        dataList.add(
            OnBoardData(
                AppCompatResources.getDrawable(this, R.drawable.onboard3),
                "Empower Your Investments",
                "Transform Your Assets with Our Intuitive Exchange Platform"
            )
        )

        adapter = OnBoardVPAdapter(dataList, this)
        binding.viewPager.adapter = adapter
//        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    1 -> {
                        setSelectedTab(binding.tab2)
                    }

                    2 -> {
                        setSelectedTab(binding.tab3)
                    }

                    else -> {
                        setSelectedTab(binding.tab1)
                    }
                }
            }
        })

        binding.nextBtn.setOnClickListener {
            if (binding.viewPager.currentItem != dataList.size - 1) {
                binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1, true)
            } else {
                startActivity(Intent(this@OnBoardActivity, LoginActivity::class.java))
                finish()
            }
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }

    private fun setSelectedTab(view: LinearLayout) {
        binding.tab1.setBackgroundResource(R.color.colorPrimaryLightest)
        binding.tab2.setBackgroundResource(R.color.colorPrimaryLightest)
        binding.tab3.setBackgroundResource(R.color.colorPrimaryLightest)

        view.setBackgroundResource(R.color.colorAccent)
    }
}