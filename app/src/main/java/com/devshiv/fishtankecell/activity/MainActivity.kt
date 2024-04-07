package com.devshiv.fishtankecell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.recyclerview.widget.RecyclerView
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.adapter.AssetAdapter
import com.devshiv.fishtankecell.adapter.CaseStudyAdapter
import com.devshiv.fishtankecell.databinding.ActivityLoginBinding
import com.devshiv.fishtankecell.databinding.ActivityMainBinding
import com.devshiv.fishtankecell.model.AssetsData
import com.devshiv.fishtankecell.model.CaseStudyData
import com.devshiv.fishtankecell.utils.SerializableTimestamp
import com.devshiv.fishtankecell.utils.Utils
import com.devshiv.fishtankecell.utils.Variables
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity(), CaseStudyAdapter.Callbacks {

    lateinit var binding: ActivityMainBinding
    var caseStudyAdapter: CaseStudyAdapter? = null
    var asseAdapter: AssetAdapter? = null
    var assetsList = ArrayList<AssetsData>()
    var caseStudyList = ArrayList<CaseStudyData>()
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAssetsData()
        getCaseStudyData()

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }

    private fun getAssetsData() {
        if (assetsList.isNotEmpty()) {
            assetsList.clear()
        }

        binding.assetsRV.visibility = View.VISIBLE
        binding.noAssetsTxt.visibility = View.GONE

        db.collection(Variables.ASSETS_FB_TAG)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val data = document.toObject(AssetsData::class.java)
                    assetsList.add(data)
                }

                if (assetsList.isNotEmpty()) {
                    binding.assetsRV.visibility = View.VISIBLE
                    binding.noAssetsTxt.visibility = View.GONE
                    asseAdapter = AssetAdapter(assetsList, this)
                    binding.assetsRV.adapter = asseAdapter
                } else {
                    binding.assetsRV.visibility = View.GONE
                    binding.noAssetsTxt.visibility = View.VISIBLE
                }
                Utils.cancelLoading()
            }
            .addOnFailureListener { exception ->
                Log.d(Variables.TAG, "Error getting documents from collection2", exception)
                Utils.cancelLoading()
                binding.assetsRV.visibility = View.GONE
                binding.noAssetsTxt.visibility = View.VISIBLE
                Toast.makeText(
                    this@MainActivity,
                    "Error : $exception",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun getCaseStudyData() {
        Utils.showLoading(this, false)

        if (caseStudyList.isNotEmpty()) {
            caseStudyList.clear()
        }

        binding.caseStudyRV.visibility = View.VISIBLE
        binding.noCaseStudyTxt.visibility = View.GONE

        db.collection(Variables.CASE_STUDY_FB_TAG)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val startDateTimestamp = document.getTimestamp("StartDate")
                    val endDateTimestamp = document.getTimestamp("EndDate")

                    // Convert Firebase Timestamp to Date
                    val startDate = startDateTimestamp?.toDate()
                    val endDate = endDateTimestamp?.toDate()

                    // Create SerializableTimestamp objects
                    val serializableStartDate = startDate?.let { SerializableTimestamp(it) }
                    val serializableEndDate = endDate?.let { SerializableTimestamp(it) }

                    val data = CaseStudyData(
                        document.getString("Title"),
                        document.getString("Banner"),
                        document.getString("Description"),
                        serializableStartDate,
                        serializableEndDate
                    )
                    caseStudyList.add(data)
                }

                if (caseStudyList.isNotEmpty()) {
                    binding.caseStudyRV.visibility = View.VISIBLE
                    binding.noCaseStudyTxt.visibility = View.GONE
                    caseStudyAdapter = CaseStudyAdapter(caseStudyList, this, this)
                    binding.caseStudyRV.adapter = caseStudyAdapter
                } else {
                    binding.caseStudyRV.visibility = View.GONE
                    binding.noCaseStudyTxt.visibility = View.VISIBLE
                }
                Utils.cancelLoading()
            }
            .addOnFailureListener { exception ->
                Log.d(Variables.TAG, "Error getting documents from collection2", exception)
                Utils.cancelLoading()
                binding.caseStudyRV.visibility = View.GONE
                binding.noCaseStudyTxt.visibility = View.VISIBLE
                Toast.makeText(
                    this@MainActivity,
                    "Error : $exception",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    override fun onClicked(pos: Int) {
        val intent = Intent(this, CaseStudyActivity::class.java)
        intent.putExtra("data", caseStudyList[pos])
        startActivity(intent)
    }

}