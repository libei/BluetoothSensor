package edu.ou.ece.cartracking.bluetoothsensor.repository

object BluetoothRecordsBuilder {

  private var xml: String = ""

  def appendTag(tagName: String) {
    xml += "<" + tagName +">"
  }

  def appendClosingTag(tagName: String) {
    xml += "</" + tagName +">"
  }

  def appendElement(name:String, value:String) {
    xml += "<" + name +">" + value + "</" + name + ">"
  }

  def toXML: String = {
    val res = xml
    xml = ""
    res
  }

}