package edu.ou.ece.cartracking.bluetoothsensor.servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

class SensorServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    resp.getWriter.append("Blahblahblah")
  }
}