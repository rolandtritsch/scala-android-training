package org.tritsch.scala.android.training.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window

import org.tritsch.scala.android.training.R

object DialogActivity {
  val TAG = classOf[DialogActivity].getName
}

class DialogActivity extends Activity {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    Log.d(DialogActivity.TAG, "Enter - onCreate")
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    setContentView(R.layout.activity_dialog)
    Log.d(DialogActivity.TAG, "Leave - onCreate")
  }

  def finishDialog(v: View): Unit = {
    Log.d(DialogActivity.TAG, "Enter - finishDialog")
    finish
    Log.d(DialogActivity.TAG, "Leave - finishDialog")
  }
}
