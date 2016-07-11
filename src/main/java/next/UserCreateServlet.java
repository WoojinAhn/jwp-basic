package next;

import ch.qos.logback.core.net.SyslogOutputStream;
import db.DataBase;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/create")
public class UserCreateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		User user = new User(userId, password, name, email);
		System.out.println("User : " + user);

		DataBase.addUser(user);
		resp.sendRedirect("/index.html");
	}
}