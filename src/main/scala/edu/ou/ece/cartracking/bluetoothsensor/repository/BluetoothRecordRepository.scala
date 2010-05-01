package edu.ou.ece.cartracking.bluetoothsensor.repository

import java.sql._

class BluetoothRecordRepository(connection: String) {

  def getRecords(): String = {

    Class.forName("org.sqlite.JDBC");
    val conn:Connection = DriverManager.getConnection(connection)
    val stat:Statement = conn.createStatement()
//    val rs: ResultSet = stat.executeQuery("select * from DataIn")

//    while (rs.next()) {
//      System.out.println("UnitTime" + rs.getInt("UnixTime"));
//      System.out.println("MacAdd" + rs.getString("MacAdd"));
//      System.out.println("DevType" + rs.getString("DevType"));
//      System.out.println("UnitSN" + rs.getString("UnitSN"));
//      System.out.println("job = " + rs.getString("occupation"));
//    }
//    rs.close()
    conn.close()
    null

  }

}