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
 * Servlet implementation class AddCustController
 */
@WebServlet("/AddAnnouncementController")
public class AddAnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnnouncementDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnnouncementController() {
        super();
        dao = new AnnouncementDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Announcement announ =new Announcement();
			
		announ.setAnnouncement_ID(Integer.parseInt(request.getParameter("Id")));
		announ.setAnnouncement_Detail(request.getParameter("Detail"));
		announ.setAnnouncement_Date(request.getParameter("Date"));

		dao.addCust(announ);
		
		
		//redirect to listData.jsp
		request.setAttribute("announce",AnnouncementDAO.getAllCust());
		RequestDispatcher view=request.getRequestDispatcher("AnnouncementList.jsp");
		view.forward(request, response);
		
	}
}
