package org.tritsch.scala.android.training.first

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.{Menu, MenuItem, View}
import android.widget.TextView
import android.widget.{EditText, Toast}

import org.tritsch.scala.android.training.R

object FirstActivity {
  val TAG = classOf[FirstActivity].getName
  val EXTRA_MESSAGE = TAG + ".MESSAGE"
}

class FirstActivity extends Activity {
  // overrides ...
  override def onCreate(savedInstanceState: Bundle): Unit = {
    Log.d(FirstActivity.TAG, "Enter - onCreate")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.first)
    Log.d(FirstActivity.TAG, "Leave - onCreate")
  }

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    Log.d(FirstActivity.TAG, "Enter - onCreateOptionsMenu")
    val didit = super.onCreateOptionsMenu(menu)
    getMenuInflater.inflate(R.menu.first, menu)
    Log.d(FirstActivity.TAG, "Leave - onCreateOptionsMenu")
    didit
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    Log.d(FirstActivity.TAG, "Enter - onOptionsItemSelected")
    val didit = item.getItemId match {
      case R.id.action_search => openSearch
      case R.id.action_settings => openSettings
      case R.id.action_help => openHelp
      case R.id.action_about => openAbout
      case R.id.action_logout => openLogout
      case _ => super.onOptionsItemSelected(item)
    }
    Log.d(FirstActivity.TAG, "Leave - onOptionsItemSelected")
    didit
  }

  // public ...
  def sendMessage(v: View): Unit = {
    Log.d(FirstActivity.TAG, "Enter - sendMessage")
    val intent = new Intent(this, classOf[DisplayMessageActivity])
    val editText = findViewById(R.id.edit_message).asInstanceOf[EditText]
    val message = editText.getText.toString
    Log.i(FirstActivity.TAG, s"Sending message >${message}< ...")
    intent.putExtra(FirstActivity.EXTRA_MESSAGE, message)
    startActivity(intent)
    Log.d(FirstActivity.TAG, "Leave - sendMessage")
  }

  // private ...
  private def openSearch: Boolean = {
    NIY
    true
  }

  private def openSettings: Boolean = {
    NIY
    true
  }

  private def openHelp: Boolean = {
    NIY
    true
  }

  private def openAbout: Boolean = {
    aboutDialog.show
    true
  }

  private def openLogout: Boolean = {
    NIY
    true
  }

  private def NIY: Unit = {
    Toast
      .makeText(getApplicationContext, "Not implemented yet!", Toast.LENGTH_SHORT)
      .show
  }

  private def aboutDialog: AlertDialog = {
    Log.d(FirstActivity.TAG, "Enter - aboutDialog")

    val title = new TextView(this)
    title.setText(R.string.about_dialog_title)
    title.setGravity(Gravity.CENTER)

    val message = new TextView(this)
    message.setText(R.string.about_dialog_message)
    message.setGravity(Gravity.CENTER)

    val dialog = new AlertDialog.Builder(this)
      .setCustomTitle(title)
      .setView(message)
      .setPositiveButton(R.string.ok, null)
      .create

    Log.d(FirstActivity.TAG, "Leave - aboutDialog")
    dialog
  }
}
