package org.tritsch.scala.android.training.lifecycle.util

import android.os.Handler
import android.util.Log
import android.widget.TextView

import java.util.List

object Utils {
  private val TAG = Utils.getClass.getName
  private val mStatusTracker = StatusTracker.ourInstance

  def printStatus(viewMethods: TextView, viewStatus: TextView): Unit = {
    require(viewMethods != null, "viewMethods != null")
    require(viewStatus != null, "viewStatus != null")
    Log.d(Utils.TAG, "Enter - printStatus")

    val handler = new Handler
    handler.postDelayed(new Runnable() {
      def run: Unit = {
        viewMethods.setText(mStatusTracker.mMethodList.mkString("\n"))
        viewStatus.setText(mStatusTracker.mStatusMap.mkString("\n"))
      }
    }, 750)
    Log.d(Utils.TAG, "Leave - printStatus")
  }
}
