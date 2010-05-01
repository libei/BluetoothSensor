package edu.ou.ece.cartracking.bluetoothsensor.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import edu.ou.ece.cartracking.bluetoothsensor.repository.BluetoothRecordRepository
import org.apache.log4j.Logger

class SensorServlet extends HttpServlet {

  private val logger: Logger = Logger.getLogger(getClass)

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    resp.setContentType("text/html");
    val dbPath = getInitParameter("dbpath")
    logger.debug("database file: " + dbPath)
    resp.getWriter.append("database file: " + dbPath)
    val repo = new BluetoothRecordRepository(dbPath)
    val start = req.getParameter("start").toLong
    val end = req.getParameter("end").toLong
    logger.debug("start: " + start + " end: " + end)
    resp.getWriter.append(repo.getRecords(start, end))
    
  }
}