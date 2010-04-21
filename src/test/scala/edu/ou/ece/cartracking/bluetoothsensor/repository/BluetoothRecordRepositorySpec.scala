package edu.ou.ece.cartracking.bluetoothsensor.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BluetoothRecordRepositorySpec extends FlatSpec with ShouldMatchers {

  it should "connect to database" in {

    val repo = new BluetoothRecordRepository("jdbc:sqlite:BlueTooth73.db")
    repo.getRecords
    true should equal(true)
    
  }
  
}