package edu.ou.ece.cartracking.bluetoothsensor.repository

import edu.ou.ece.cartracking.bluetoothsensor.repository
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec

@RunWith(classOf[JUnitRunner])
class BluetoothRecordsBuilderSpec extends FlatSpec with ShouldMatchers {

  it should "generate the xml root" in {

    BluetoothRecordsBuilder.appendTag("records")
    BluetoothRecordsBuilder.appendClosingTag("records")
    BluetoothRecordsBuilder.toXML should equal ("<records></records>")

  }

  it should "append records" in {
    BluetoothRecordsBuilder.appendTag("record")
    BluetoothRecordsBuilder.appendElement("UnitTime", "12345")
    BluetoothRecordsBuilder.appendElement("MacAdd", "HD:22:FD")
    BluetoothRecordsBuilder.appendClosingTag("record")

    BluetoothRecordsBuilder.toXML should equal("<record><UnitTime>12345</UnitTime><MacAdd>HD:22:FD</MacAdd></record>")
  }

}