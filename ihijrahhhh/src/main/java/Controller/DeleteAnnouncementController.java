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
 * Servlet implementation class DeleteCustController
 */
@WebServlet("/DeleteAnnouncementController")
public class DeleteAnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDAO dao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnnouncementController() {
        super();
        dao = new AnnouncementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("Id"));
		dao.deleteServ(id);
		request.setAttribute("announce",AnnouncementDAO.getAllCust());

		RequestDispatcher view = request.getRequestDispatcher("listCust.jsp");
		view.forward(request, response);
	}

}