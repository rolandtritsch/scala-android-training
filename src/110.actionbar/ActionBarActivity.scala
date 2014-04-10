package org.tritsch.scala.android.training.action

import android.app.ActionBar
import android.app.Activity
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import org.tritsch.scala.android.training.R

object ActionBarActivity {
  val TAG = classOf[ActionBarActivity].getName
}

class ActionBarActivity extends Activity {
  val listenToTab = new ActionBar.TabListener {
    override def onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction): Unit = {
      Toast.makeText(getApplicationContext, s"Selected >${tab.getText}< ...", Toast.LENGTH_SHORT).show
    }
    override def onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction): Unit = {}
    override def onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction): Unit = {}
  }

  // overrides ...
  override def onCreate(savedInstanceState: Bundle): Unit = {
    Log.d(ActionBarActivity.TAG, "Enter - onCreate")
    super.onCreate(savedInstanceState)

    val actionBar = getActionBar
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setDisplayShowTitleEnabled(true)

    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS)
    actionBar.addTab(actionBar.newTab.setText("North").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("East").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("South").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("West").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("Up").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("Down").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("Left").setTabListener(listenToTab))
    actionBar.addTab(actionBar.newTab.setText("Right").setTabListener(listenToTab))

    Log.d(ActionBarActivity.TAG, "Leave - onCreate")
  }

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    Log.d(ActionBarActivity.TAG, "Enter - onCreateOptionsMenu")
    val didit = super.onCreateOptionsMenu(menu)
    getMenuInflater.inflate(R.menu.actionbar, menu)
    Log.d(ActionBarActivity.TAG, "Leave - onCreateOptionsMenu")
    didit
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    Log.d(ActionBarActivity.TAG, "Enter - onOptionsItemSelected")
    val didit = item.getItemId match {
      case R.id.action_search => NIY("Search")
      case R.id.action_mail => NIY("Mail")
      case R.id.action_cut => NIY("Cut")
      case R.id.action_copy => NIY("Copy")
      case R.id.action_paste => NIY("Paste")
      case R.id.action_settings => NIY("Settings")
      case R.id.action_help => NIY("Help")
      case R.id.action_about => NIY("About")
      case _ => super.onOptionsItemSelected(item)
    }
    Log.d(ActionBarActivity.TAG, "Leave - onOptionsItemSelected")
    didit
  }

  private def NIY(what: String): Boolean = {
    Toast
      .makeText(getApplicationContext, s">${what}< not implemented yet!", Toast.LENGTH_SHORT)
      .show
    true
  }
}
