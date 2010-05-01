package edu.ou.ece.cartracking.bluetoothsensor.repository

import java.sql._

class BluetoothRecordRepository(connection: String) {

  def getRecords(startTime: Long , endTime:Long): String = {

    Class.forName("org.sqlite.JDBC");
    val conn:Connection = DriverManager.getConnection(connection)
    val stat:Statement = conn.createStatement()
    val rs: ResultSet = stat.executeQuery("select * from DataIn where UnixTime >" + startTime + " and UnixTime < " + endTime)
    BluetoothRecordsBuilder.appendTag("records")
    while (rs.next()) {
      BluetoothRecordsBuilder.appendTag("record")
      BluetoothRecordsBuilder.appendElement("UnixTime", rs.getInt("UnixTime").toString)
      BluetoothRecordsBuilder.appendElement("MacAdd", rs.getString("MacAdd"))
      BluetoothRecordsBuilder.appendElement("DevType", rs.getString("DevType"))
      BluetoothRecordsBuilder.appendElement("UnitSN", rs.getString("UnitSN"))
      BluetoothRecordsBuilder.appendClosingTag("record")
    }
    BluetoothRecordsBuilder.appendClosingTag("records")
    rs.close()
    conn.close()
    BluetoothRecordsBuilder.toXML

  }

}