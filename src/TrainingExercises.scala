package org.tritsch.scala.android.training

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

import org.tritsch.scala.android.training.first.FirstActivity
import org.tritsch.scala.android.training.action.ActionBarActivity
import org.tritsch.scala.android.training.lifecycle.ActivityA

object TrainingExercises {
  val TAG = classOf[TrainingExercises].getName
}

class TrainingExercises extends Activity {
  val exercises = Array("First App ...", "Action Bar ...", "Devices ...", "Lifecycle ...")

  // listeners ...
  val listenForSelectedExercise = new AdapterView.OnItemClickListener {
    override def onItemClick(parent: AdapterView[_], view: View, position: Int, id: Long): Unit = {
      position match {
        case 0 => startActivity(new Intent(getApplicationContext, classOf[FirstActivity]))
        case 1 => startActivity(new Intent(getApplicationContext, classOf[ActionBarActivity]))
        case 2 => Toast.makeText(getApplicationContext, "Devices: Not implemented yet", Toast.LENGTH_LONG).show
        case 3 => startActivity(new Intent(getApplicationContext, classOf[ActivityA]))
        case _ => {
          Log.wtf(TrainingExercises.TAG, "Unknow item found")
          assert(false, "Unkown item found")
        }
      }
    }
  }

  // overrides ...
  override def onCreate(savedInstanceState: Bundle): Unit = {
    Log.d(TrainingExercises.TAG, "Enter - onCreate")
    super.onCreate(savedInstanceState)

    val listView = new ListView(this)
    listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, exercises))
    listView.setOnItemClickListener(listenForSelectedExercise)

    setContentView(listView)
    Log.d(TrainingExercises.TAG, "Leave - onCreate")
  }

}
