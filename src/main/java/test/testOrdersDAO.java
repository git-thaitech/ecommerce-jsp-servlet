package test;

import dao.OrdersDAO;

public class testOrdersDAO {
	
	public static void main(String[] arg) {
		testDeleteOrder();
	}
	
	public static int testGetLastestIndex() {
		OrdersDAO ordersDAO = new OrdersDAO();
		return ordersDAO.getLastestIndex();
	}
	
	public static void testDeleteOrder() {
		OrdersDAO ordersDAO = new OrdersDAO();
		ordersDAO.delete(12);
	}

}
