package edu.ou.ece.cartracking.bluetoothsensor.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import edu.ou.ece.cartracking.bluetoothsensor.repository.BluetoothRecordRepository
import org.apache.log4j.Logger
import java.lang.String

class SensorServlet extends HttpServlet {

  private val logger: Logger = Logger.getLogger(getClass)

  private def extractParms(req: HttpServletRequest): Tuple2[Long, Long] = {
    val startParm: String = req.getParameter("start")
    val endParm: String = req.getParameter("end")

//    if(startParm == null || endParm == null)
//      resp.getWriter.append("<error>reques should be in ?start=unixtime&end=unixtime format.</error>")

    val start = startParm.toLong
    val end = endParm.toLong
    logger.debug("start: " + start + " end: " + end)

    (start, end)

  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    resp.setContentType("text/xml");
    val dbPath = getInitParameter("dbpath")
    logger.debug("database file: " + dbPath)
    val (start, end) = extractParms(req)
    val repo = new BluetoothRecordRepository("jdbc:sqlite:" + dbPath)
    resp.getWriter.append(repo.getRecords(start, end))
    
  }
}