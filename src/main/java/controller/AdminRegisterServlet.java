package controller;

import model.Admin;
import dao.AdminRegisterdao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/register")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminRegisterdao adminRegisterdao=new AdminRegisterdao();
    /**
     * Default constructor. 
     */
    public AdminRegisterServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/Adminregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		Admin Admin=new Admin();
		Admin.setFirstname(firstname);
		Admin.setContact(contact);
		Admin.setLastname(lastname);
		Admin.setAddress(address);
		Admin.setUsername(username);
		Admin.setPassword(password);
		try {
			adminRegisterdao.registeradmin(Admin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/Registersuccess.jsp");
		dispatcher.forward(request, response);
	}
}