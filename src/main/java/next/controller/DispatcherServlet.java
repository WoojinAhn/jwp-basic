package next.controller;

import next.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = {"", "/"}, loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestMapping rm = new RequestMapping();
        String requestUri = req.getRequestURI();
        Controller controller = rm.findController(requestUri);
        try {
            String viewName = controller.execute(req, resp);
            RequestDispatcher rd = req.getRequestDispatcher(viewName);
            rd.forward(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }
}