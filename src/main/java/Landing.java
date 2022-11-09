

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Landing
 */
@WebServlet("/Landing")
public class Landing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Landing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String unit = request.getParameter("unit");
		String duedate = request.getParameter("duedate");
		System.out.print(username+" = "+unit+"="+duedate);
		RegistrationDb rDb = new RegistrationDb();
		ArrayList result = rDb.UpdateBill(username,duedate,unit);
		System.out.print(result);
		session.setAttribute("UserDetails",result);
//		response.getWriter().print(result);
		
		response.sendRedirect("/Eb_bill/home.jsp");
	}

}
