package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Systemdao;
import model.Product;
//import model.Product;
@WebServlet("/updaterow")
public class UpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Systemdao systemdao;
	public void init() {systemdao=new Systemdao();};
    /**
     * Default constructor. 
     */
    public UpdateServlet() {
        super();// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/updaterow.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product=new Product();
		// TODO Auto-generated method stub
		product.setItem(request.getParameter("item"));	
		product.setPrice(request.getParameter("price"));	
		product.setAmount(request.getParameter("amount"));	
		product.setColor(request.getParameter("color"));
		String data;
		try {
			data=systemdao.update(product)?"Updated successfully":"Not possible";
			request.setAttribute("data", data);
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/updaterow.jsp");
			dispatcher.forward(request, response);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	