package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String EDIT="/edit.jsp";
	private static String LIST_USER="/listUser.jsp";
	private User user;
	private UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        dao= new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user= (User) request.getAttribute("user");
		RequestDispatcher view = request.getRequestDispatcher(EDIT);
		request.setAttribute("user", user);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userEdit=new User();
		userEdit.setName(request.getParameter("name"));
		userEdit.setPassword(request.getParameter("password"));
		userEdit.setAddress(request.getParameter("address"));
		try {
			userEdit.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("birthday")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userEdit.setMarital(request.getParameter("marital"));
		userEdit.setJob(request.getParameter("job"));
		dao.updateUser(userEdit, user.getName());
		
		RequestDispatcher view= request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request,response );
	}

}
