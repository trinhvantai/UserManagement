package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Account;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
	private static String LOGIN = "/login.jsp";
	private static String LIST_USER="/listUser.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		dao = new UserDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view= request.getRequestDispatcher(LOGIN);
		Account acc= new Account();
		acc.setName(request.getParameter("name"));
		acc.setPassword(request.getParameter("password"));
		
		request.setAttribute("acc", acc);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account acc = new Account();
		acc.setName(request.getParameter("name"));
		acc.setPassword(request.getParameter("password"));
		if(dao.isHadUser(acc)){
			RequestDispatcher view= request.getRequestDispatcher(LIST_USER);
			request.setAttribute("users", dao.getAllUsers());
			view.forward(request,response );
		}
		else{
			RequestDispatcher view= request.getRequestDispatcher(LOGIN);
			view.forward(request, response);
		}
		
	}

}
