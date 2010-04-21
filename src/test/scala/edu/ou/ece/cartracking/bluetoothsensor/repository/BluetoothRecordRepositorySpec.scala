package edu.ou.ece.cartracking.bluetoothsensor.repository

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class BluetoothRecordRepositorySpec extends FlatSpec with ShouldMatchers {

  it should "connect to database" in {

    val repo = new BluetoothRecordRepository("jdbc:sqlite:BlutTooth73.db")
    repo.getRecords
    
  }
  
}