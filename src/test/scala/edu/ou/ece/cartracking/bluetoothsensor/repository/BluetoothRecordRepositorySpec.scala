package edu.ou.ece.cartracking.bluetoothsensor.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.net.URL
import java.lang.String

@RunWith(classOf[JUnitRunner])
class BluetoothRecordRepositorySpec extends FlatSpec with ShouldMatchers {

  it should "connect to database" in {
    val dbPath = this.getClass.getClassLoader.getResource("BlueTooth73.db").getPath
    val repo = new BluetoothRecordRepository("jdbc:sqlite:" + dbPath)
    val xml = repo.getRecords(1268223396, 1269263000)

    shouldContain(xml, "<records>")
    shouldContain(xml, "</records>")
    shouldContain(xml, "<record><UnixTime>1268223396</UnixTime><MacAdd>00:01:95:09:5A:D3</MacAdd><DevType>DesktopComputer</DevType><UnitSN>001-001-001</UnitSN></record>")
    shouldContain(xml, "<record><UnixTime>1269262993</UnixTime><MacAdd>00:16:74:4B:0B:29</MacAdd><DevType>HeadsetAudio/Video</DevType><UnitSN>001-001-001</UnitSN></record>")

  }

  def shouldContain(xml: String, substring: String) {
    xml.contains(substring) should equal(true)
  }
  
}