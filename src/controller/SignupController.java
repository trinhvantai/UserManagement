package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.security.auth.login.AccountException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Account;
import model.User;

public class SignupController extends HttpServlet {

	private UserDao dao;
	private static String LOGIN="/login.jsp";
	private static String LIST_USER="/listUser.jsp";
	private static String EDIT="/edit.jsp";
	public SignupController() {
		super();
		dao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action= req.getParameter("action");
		String name= req.getParameter("name");
		if(action.equalsIgnoreCase("delete")){
			dao.deleteUser(name);
			RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
			req.setAttribute("users", dao.getAllUsers());
			view.forward(req, resp);
		}
		else{
			User user= dao.getUserByName(name);
			/*RequestDispatcher view = req.getRequestDispatcher(EDIT);
			req.setAttribute("user", user);
			view.forward(req, resp);*/
			RequestDispatcher fwToEditControl= req.getRequestDispatcher("/edit");
			req.setAttribute("user", user);
			fwToEditControl.forward(req, resp);
		}
		
	}
//	save info user registed,render view for log in.
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("password"));
		user.setAddress(req.getParameter("address"));
		try {
			user.setBirthday(new SimpleDateFormat("yyyy/mm/dd").parse(req.getParameter("birthday")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setMarital(req.getParameter("marital"));
		user.setJob(req.getParameter("job"));
		dao.addUser(user);
		Account acc= new Account();
		acc.setName(req.getParameter("name"));
		acc.setPassword(req.getParameter("password"));
		RequestDispatcher view= req.getRequestDispatcher(LOGIN);
		req.setAttribute("acc", acc);
		view.forward(req, resp);
		
	}

}
