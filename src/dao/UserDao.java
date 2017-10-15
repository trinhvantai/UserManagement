package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.User;
import util.DBconnect;

public class UserDao {

	private Connection connection;
	public UserDao() {
		connection = DBconnect.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into us(name,password,address,birthday,marital,job) values (?, ?, ?, ?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			preparedStatement.setString(5, user.getMarital());
			preparedStatement.setString(6, user.getJob());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String name) {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("delete from us where name=?");
			// Parameters start with 1
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user, String name) {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(
					"update us set name=?, password=?, address=?, birthday=?,marital=?,job=? where name= ?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			preparedStatement.setString(5, user.getMarital());
			preparedStatement.setString(6, user.getJob());
			preparedStatement.setString(7, name);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from us");
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMarital(rs.getString("marital"));
				user.setJob(rs.getString("job"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public boolean isHadUser(Account acc) {
		User user = new User();
		boolean isHad=false;
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from us where name=? and password=?");
			preparedStatement.setString(1, acc.getName());
			preparedStatement.setString(2, acc.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) 
				isHad=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isHad;
	}

	public User getUserByName(String name) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from us where name=?");
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMarital(rs.getString("marital"));
				user.setJob(rs.getString("job"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public static void main(String args[]) throws ParseException {

		UserDao dao = new UserDao();
		User user = new User();
		user.setName("duong");
		user.setPassword("duong");
		user.setAddress("hoang quoc viet");
		user.setBirthday(new SimpleDateFormat("yyyy/mm/dd").parse("2004/12/12"));
		user.setMarital("no");
		user.setJob("student");
		dao.updateUser(user, "vt");

		// UserDao dao = new UserDao();
		// Account acc = new Account(); acc.setName("vt");
		// acc.setPassword("vt"); dao.getUserByAccount(acc);

	}
}