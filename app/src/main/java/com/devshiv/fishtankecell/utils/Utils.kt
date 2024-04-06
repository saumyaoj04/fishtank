package com.devshiv.fishtankecell.utils

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.devshiv.fishtankecell.R
import com.devshiv.fishtankecell.databinding.CustomDialogLayoutBinding
import com.devshiv.fishtankecell.databinding.LoadingDialogBinding

object Utils {

    var loadingDialog: Dialog? = null
    var loadingHandler = Handler()
    var loadingRunnable: Runnable? = null

    fun showLoading(activity: Activity, isCancelable: Boolean) {
        if (!activity.isFinishing) {
            cancelLoading()
            loadingDialog = Dialog(activity)
            val binding = LoadingDialogBinding.inflate(
                LayoutInflater.from(
                    loadingDialog!!.context
                )
            )
            loadingDialog!!.setContentView(binding.root)
            try {
                loadingDialog!!.window!!.setDimAmount(0.8f)
                loadingDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                loadingDialog!!.window!!.attributes.windowAnimations =
                    R.style.MyDialogAnimation_Dialog // style id
            } catch (e: Exception) {
                Log.d(Variables.TAG, "showLoading: " + e.message)
            }
            loadingDialog!!.setCanceledOnTouchOutside(false)
            loadingDialog!!.setCancelable(isCancelable)
            loadingDialog!!.show()
            loadingRunnable = Runnable {
//                    if (!activity.isFinishing()) {
//                        Toast.makeText(activity, "Some Error Occurred", Toast.LENGTH_SHORT).show();
//                    }
                cancelLoading()
            }
            loadingHandler.postDelayed(loadingRunnable!!, 8000)
        }
    }

    fun cancelLoading() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            try {
                loadingDialog!!.cancel()
                loadingDialog = null
                if (loadingRunnable != null) {
                    loadingHandler.removeCallbacks(loadingRunnable!!)
                    loadingRunnable = null
                }
            } catch (e: Exception) {
                Log.d(Variables.TAG, "cancelLoading: " + e.message)
            }
        }
    }

    fun showDialog(
        activity: Activity,
        title: String?,
        message: String?,
        isCancelable: Boolean,
        dialogCallback: DialogInterface.OnDismissListener?
    ) {
        if (!activity.isFinishing) {
            val customDialog = Dialog(activity)
            val binding =
                CustomDialogLayoutBinding.inflate(LayoutInflater.from(customDialog.context))
            customDialog.setContentView(binding.root)
            try {
                customDialog.window!!.setDimAmount(0.6f)
                customDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                customDialog.window!!.attributes.windowAnimations =
                    R.style.MyDialogAnimation_Dialog // style id
            } catch (e: Exception) {
                Log.d(Variables.TAG, "showLoading: " + e.message)
            }
            customDialog.setCanceledOnTouchOutside(true)
            customDialog.setCancelable(isCancelable)
            binding.titleTxt.text = title
            binding.descriptionTxt.text = message
            binding.iconTxt.setImageDrawable(
                ContextCompat.getDrawable(
                    activity,
                    R.drawable.app_icon
                )
            )
            binding.okBtn.setOnClickListener { customDialog.dismiss() }
            if (dialogCallback != null) {
                customDialog.setOnDismissListener(dialogCallback)
            }
            customDialog.show()
        }
    }
}
