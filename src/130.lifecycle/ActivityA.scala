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

object ActivityA {
  val TAG = classOf[ActivityA].getName
}

class ActivityA extends Activity {
  private var mActivityName: String = null
  private var mStatusView: TextView = null
  private var mStatusAllView: TextView = null
  private val mStatusTracker = StatusTracker.ourInstance

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    Log.d(ActivityA.TAG, "Enter - onCreate")

    setContentView(R.layout.activity_a)
    mActivityName = getString(R.string.activity_a)
    mStatusView = findViewById(R.id.status_view_a).asInstanceOf[TextView]
    mStatusAllView = findViewById(R.id.status_view_all_a).asInstanceOf[TextView]
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_create))
    Utils.printStatus(mStatusView, mStatusAllView);

    Log.d(ActivityA.TAG, "Leave - onCreate")
  }

  override protected def onStart: Unit = {
    super.onStart
    Log.d(ActivityA.TAG, "Enter - onStart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_start))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityA.TAG, "Leave - onStart")
  }

  override protected def onRestart: Unit = {
    super.onRestart
    Log.d(ActivityA.TAG, "Enter - onRestart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityA.TAG, "Leave - onRestart")
  }

  override protected def onResume: Unit = {
    super.onResume
    Log.d(ActivityA.TAG, "Enter - onResume")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityA.TAG, "Leave - onResume")
  }

  override protected def onPause: Unit = {
    super.onPause
    Log.d(ActivityA.TAG, "Enter - onPause")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityA.TAG, "Leave - onPause")
  }

  override protected def onStop: Unit = {
    super.onStop
    Log.d(ActivityA.TAG, "Enter - onStop")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop))
    Log.d(ActivityA.TAG, "Leave - onStop")
  }

  override protected def onDestroy() {
    Log.d(ActivityA.TAG, "Enter - onDestroy")
    super.onDestroy()
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy))
    mStatusTracker.clear
    Log.d(ActivityA.TAG, "Leave - onDestroy")
  }

  def startDialog(v: View): Unit = startActivity(new Intent(this, classOf[DialogActivity]))

  def startActivityB(v: View): Unit = startActivity(new Intent(this, classOf[ActivityB]))

  def startActivityC(v: View): Unit = startActivity(new Intent(this, classOf[ActivityC]))

  def finishActivityA(v: View): Unit = finish
}
