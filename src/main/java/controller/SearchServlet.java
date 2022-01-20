package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.io.PrintWriter;
import model.Product;
import dao.Systemdao;
@WebServlet("/searchrow")
public class SearchServlet extends HttpServlet{
	public String item;
	private static final long serialVersionUID = 1L;
	ArrayList<Product> l=new ArrayList<Product>();
	private Systemdao systemdao;    
	/**
     * Default constructor. 
     */
    public SearchServlet() {
        super();// TODO Auto-generated constructor stub
    }
    public void init() {systemdao=new Systemdao();}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		 
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/searchrow.jsp");
		dispatcher.forward(request, response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		HttpSession session = request.getSession(true);
		item=request.getParameter("iteminput");
		try {	
			this.l=systemdao.search(item);
			if(l!=null) {
				session.setAttribute("list",l);
			}			
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/searchrow.jsp");
			dispatcher.forward(request, response);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	