package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AnnouncementDAO;


/**
 * Servlet implementation class ListCustController
 */
@WebServlet("/ListAnnouncementController")
public class ListAnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAnnouncementController() {
        super();
        dao = new AnnouncementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("announce", AnnouncementDAO.getAllCust());
		RequestDispatcher view = request.getRequestDispatcher("listCust.jsp");
		view.forward(request, response);
	}
	
	


}
