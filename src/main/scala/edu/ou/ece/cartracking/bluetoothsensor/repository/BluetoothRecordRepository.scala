package edu.ou.ece.cartracking.bluetoothsensor.repository

import edu.ou.ece.cartracking.bluetoothsensor.domain.BluetoothRecord
import java.sql._

object BluetoothRecordRepository {

  def getRecords(): List[BluetoothRecord] = {

    Class.forName("org.sqlite.JDBC");
    val conn:Connection = DriverManager.getConnection("jdbc:sqlite:BlutTooth73.db")
    val stat:Statement = conn.createStatement()
    val rs: ResultSet = stat.executeQuery("select * from DataIn;")

    while (rs.next()) {
//      System.out.println("UnitTime" + rs.getInt("UnixTime"));
//      System.out.println("MacAdd" + rs.getString("MacAdd"));
//      System.out.println("DevType" + rs.getString("DevType"));
//      System.out.println("UnitSN" + rs.getString("UnitSN"));
//      System.out.println("job = " + rs.getString("occupation"));
    }
    rs.close()
    null

  }

}