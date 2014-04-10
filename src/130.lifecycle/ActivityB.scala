package org.tritsch.scala.android.training.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import org.tritsch.scala.android.training.lifecycle.util.StatusTracker
import org.tritsch.scala.android.training.lifecycle.util.Utils

import org.tritsch.scala.android.training.R

object ActivityB {
  val TAG = classOf[ActivityB].getName
}

class ActivityB extends Activity {
  private var mActivityName: String = null
  private var mStatusView: TextView = null
  private var mStatusAllView: TextView = null
  private val mStatusTracker = StatusTracker.ourInstance

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    Log.d(ActivityB.TAG, "Enter - onCreate")

    setContentView(R.layout.activity_b)
    mActivityName = getString(R.string.activity_b)
    mStatusView = findViewById(R.id.status_view_b).asInstanceOf[TextView]
    mStatusAllView = findViewById(R.id.status_view_all_b).asInstanceOf[TextView]
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_create))
    Utils.printStatus(mStatusView, mStatusAllView);

    Log.d(ActivityB.TAG, "Leave - onCreate")
  }

  override protected def onStart: Unit = {
    super.onStart
    Log.d(ActivityB.TAG, "Enter - onStart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_start))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityB.TAG, "Leave - onStart")
  }

  override protected def onRestart: Unit = {
    super.onRestart
    Log.d(ActivityB.TAG, "Enter - onRestart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityB.TAG, "Leave - onRestart")
  }

  override protected def onResume: Unit = {
    super.onResume
    Log.d(ActivityB.TAG, "Enter - onResume")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityB.TAG, "Leave - onResume")
  }

  override protected def onPause: Unit = {
    super.onPause
    Log.d(ActivityB.TAG, "Enter - onPause")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityB.TAG, "Leave - onPause")
  }

  override protected def onStop: Unit = {
    super.onStop
    Log.d(ActivityB.TAG, "Enter - onStop")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop))
    Log.d(ActivityB.TAG, "Leave - onStop")
  }

  override protected def onDestroy() {
    Log.d(ActivityB.TAG, "Enter - onDestroy")
    super.onDestroy()
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy))
    mStatusTracker.clear
    Log.d(ActivityB.TAG, "Leave - onDestroy")
  }

  def startDialog(v: View): Unit = startActivity(new Intent(this, classOf[DialogActivity]))

  def startActivityA(v: View): Unit = startActivity(new Intent(this, classOf[ActivityA]))

  def startActivityC(v: View): Unit = startActivity(new Intent(this, classOf[ActivityC]))

  def finishActivityB(v: View): Unit = finish
}
