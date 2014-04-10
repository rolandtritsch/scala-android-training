package org.tritsch.scala.android.training.first

import android.app.Activity
import android.os.{Build, Bundle}
import android.support.v4.app.NavUtils
import android.util.Log
import android.view.MenuItem
import android.widget.TextView

object DisplayMessageActivity {
  val TAG = classOf[DisplayMessageActivity].getName
}

class DisplayMessageActivity extends Activity {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    Log.d(DisplayMessageActivity.TAG, "Enter - onCreate")

    // Show the Up button in the action bar.
    getActionBar.setDisplayHomeAsUpEnabled(true)

    // Extract the message from the intent that this activity is processing
    val message = getIntent.getStringExtra(FirstActivity.EXTRA_MESSAGE).reverse.toUpperCase
    Log.i(DisplayMessageActivity.TAG, s"Got message >${message}< ...")

    // Create the text view
    val textView = new TextView(this)
    textView.setTextSize(40)
    textView.setText(message)

    // Set the text view as the activity layout
    setContentView(textView)
    Log.d(DisplayMessageActivity.TAG, "Leave - onCreate")
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    Log.d(DisplayMessageActivity.TAG, "Enter - onOptionsItemSelected")
    val didit = item.getItemId match {
      case android.R.id.home => {
        NavUtils.navigateUpFromSameTask(this)
        true
      }
      case _ => super.onOptionsItemSelected(item)
    }
    Log.d(DisplayMessageActivity.TAG, "Leave - onOptionsItemSelected")
    didit
  }
}
