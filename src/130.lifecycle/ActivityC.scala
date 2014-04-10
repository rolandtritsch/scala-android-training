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

object ActivityC {
  val TAG = classOf[ActivityC].getName
}

class ActivityC extends Activity {
  private var mActivityName: String = null
  private var mStatusView: TextView = null
  private var mStatusAllView: TextView = null
  private val mStatusTracker = StatusTracker.ourInstance

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    Log.d(ActivityC.TAG, "Enter - onCreate")

    setContentView(R.layout.activity_c)
    mActivityName = getString(R.string.activity_c)
    mStatusView = findViewById(R.id.status_view_c).asInstanceOf[TextView]
    mStatusAllView = findViewById(R.id.status_view_all_c).asInstanceOf[TextView]
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_create))
    Utils.printStatus(mStatusView, mStatusAllView);

    Log.d(ActivityC.TAG, "Leave - onCreate")
  }

  override protected def onStart: Unit = {
    super.onStart
    Log.d(ActivityC.TAG, "Enter - onStart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_start))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityC.TAG, "Leave - onStart")
  }

  override protected def onRestart: Unit = {
    super.onRestart
    Log.d(ActivityC.TAG, "Enter - onRestart")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityC.TAG, "Leave - onRestart")
  }

  override protected def onResume: Unit = {
    super.onResume
    Log.d(ActivityC.TAG, "Enter - onResume")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityC.TAG, "Leave - onResume")
  }

  override protected def onPause: Unit = {
    super.onPause
    Log.d(ActivityC.TAG, "Enter - onPause")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause))
    Utils.printStatus(mStatusView, mStatusAllView)
    Log.d(ActivityC.TAG, "Leave - onPause")
  }

  override protected def  onStop: Unit = {
    super.onStop
    Log.d(ActivityC.TAG, "Enter - onStop")
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop))
    Log.d(ActivityC.TAG, "Leave - onStop")
  }

  override protected def onDestroy() {
    Log.d(ActivityC.TAG, "Enter - onDestroy")
    super.onDestroy()
    mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy))
    mStatusTracker.clear
    Log.d(ActivityC.TAG, "Leave - onDestroy")
  }

  def startDialog(v: View): Unit = startActivity(new Intent(this, classOf[DialogActivity]))

  def startActivityA(v: View): Unit = startActivity(new Intent(this, classOf[ActivityA]))

  def startActivityB(v: View): Unit = startActivity(new Intent(this, classOf[ActivityB]))

  def finishActivityC(v: View): Unit = finish
}
