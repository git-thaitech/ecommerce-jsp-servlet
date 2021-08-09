package dao;

import java.util.ArrayList;

public interface GenericDAO<T> {
	static final String DB_URL = "jdbc:mysql://localhost:3306/shoppingdb?useSSL=true";
	static final String USER = "root";
	static final String PASS = "1234";

	public int create(T t);

	public T get(Object id);

	public T update(T t);

	public void delete(Object id);

	public long count();

	public ArrayList<T> listAll();
}
