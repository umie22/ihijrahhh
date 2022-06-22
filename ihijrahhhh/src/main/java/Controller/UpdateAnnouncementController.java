package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AnnouncementDAO;
import Model.Announcement;

/**
 * Servlet implementation class UpdateCustController
 */
@WebServlet("/UpdateAnnouncementController")
public class UpdateAnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnnouncementController() {
        super();
        dao = new AnnouncementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("announce", AnnouncementDAO.getCustomerById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateCust.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Announcement announcement =new Announcement();
		
		announcement.setAnnouncement_ID(Integer.parseInt(request.getParameter("Id")));
		announcement.setAnnouncement_Detail(request.getParameter("Detail"));
		announcement.setAnnouncement_Date(request.getParameter("Date"));

		
		

		dao.updateCust(announcement);
		
		//redirect to listData.jsp
		request.setAttribute("customers",AnnouncementDAO.getAllCust());
		RequestDispatcher view=request.getRequestDispatcher("AnnouncementList.jsp");
		view.forward(request, response);
	}

}
