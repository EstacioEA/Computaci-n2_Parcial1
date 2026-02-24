package servlet;

import config.AppConfig;
import context.AppContext;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import service.MeasurementService;

import java.io.IOException;

@WebServlet
public class MeasurementServlet extends HttpServlet {

    private MeasurementService measurementService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        measurementService = (MeasurementService) AppContext.getContext().getBean("measurementService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
