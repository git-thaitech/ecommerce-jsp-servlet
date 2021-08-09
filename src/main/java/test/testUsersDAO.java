package test;

import java.util.ArrayList;

import dao.UsersDAO;
import model.Users;

public class testUsersDAO {

	public static void main(String[] args) {
		
		System.out.print(testCountUsers());
		
		
	}
	
	
	public static void testDeleteUser() {
		UsersDAO usersDAO = new UsersDAO();
		
		usersDAO.delete("1234");
		usersDAO.delete("123423");
		usersDAO.delete("2131");
	}
	
	public static ArrayList<Users> testListUsers() {
		UsersDAO usersDAO = new UsersDAO();
		
		return usersDAO.listAll();
	}
	
	public static long testCountUsers() {
		UsersDAO usersDAO = new UsersDAO();
		
		return usersDAO.count();
	}
}
