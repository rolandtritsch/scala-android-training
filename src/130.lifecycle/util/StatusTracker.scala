package org.tritsch.scala.android.training.lifecycle.util

import scala.collection.mutable

object StatusTracker {
  private val TAG = classOf[StatusTracker].getName
  protected[lifecycle] val ourInstance = new StatusTracker
}

class StatusTracker {
  protected[util] val mStatusMap: mutable.Map[String, String] = new mutable.HashMap[String, String]
  protected[util] val mMethodList: mutable.MutableList[String] = new mutable.MutableList[String]

  def clear: Unit = {
    mMethodList.clear
    mStatusMap.clear
  }

  def setStatus(activityName: String, status: String): Unit = {
    mMethodList += s"${activityName}.${status}()"
    mStatusMap += (activityName -> status)
  }

  def getStatus(activityName: String): String = {
    mStatusMap(activityName)
  }
}
