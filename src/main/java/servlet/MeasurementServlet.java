package servlet;

import context.AppContext;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Measurement;
import service.MeasurementService;

import java.io.IOException;
import java.io.InputStream;

@WebServlet
public class MeasurementServlet extends HttpServlet {

    private MeasurementService measurementService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        measurementService = (MeasurementService) AppContext.getContext().getBean("measurementService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        InputStream in = getClass().getClassLoader().getResourceAsStream("measurements.html");
        String content = new String(in.readAllBytes());

        resp.getWriter().println(content);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Measurement measurement = new Measurement();
        measurement.setId(Integer.parseInt(req.getParameter("Id")));
        measurement.setTimestamp(Integer.parseInt(req.getParameter("Timestamp")));
        measurement.setValue(Double.parseDouble(req.getParameter("Value")));
        measurement.setDeviceId(Integer.parseInt(req.getParameter("Schedule")));
        measurementService.addMeasurement(measurement);
        resp.sendRedirect("./measurements");
    }
}
