package Practise2025.CompanyS;

import java.util.*;
import java.util.stream.Collectors;

/*

Goal: Transform/join datasets for order-related records.
Requirements:
Implement operations like:
1.Join orders with clients (inner/outer)
2. Filter, sort, or aggregate based on keys


Handle missing data cases
UserTable
	UserId
	UserInformation


Order Table
	OrderId 
	OrderDetail 
	UserId


 */

class Order{
	String orderId;
	String orderDetails;
	String userId;
	
	public Order(String orderId, String orderDetails, String userId) {
		this.orderId = orderId;
		this.orderDetails = orderDetails;
		this.userId = userId;
	}
	
	@Override
	public boolean equals(Object order) {
		if(!(order instanceof Order)) {
			return false;
		}
		Order inputOrder = (Order) order;
		if(inputOrder.orderId.equals(this.orderId)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.orderId);
	}
	
	@Override
	public String toString() {
		return orderId + " " + orderDetails + " " + userId;
	}

}

class User{
	String userId;
	String mail;
	
	public User(String userId, String mail) {
		this.userId = userId;
		this.mail = mail;
	}
	
	@Override
	public boolean equals(Object user) {
		if(!(user instanceof User)) {
			return false;
		}
		User inputUser = (User) user;
		if(inputUser.userId.equals(this.userId)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.userId);
	}
	
	@Override
	public String toString() {
		return userId + " " + mail;
	}
}

class OrderDao{
	HashSet<Order> orderSet;
	
	public OrderDao() {
		orderSet = new HashSet<>();
	}
	
	public boolean addOrder(Order order) {
		if(orderSet.contains(order)) {
			return false;
		}
		orderSet.add(order);
		return true;
	}
	
	public Set<Order> filterBy(String userid){
		return orderSet.stream().filter(a -> a.userId.equals(userid)).collect(Collectors.toSet());
	}
}

public class OrderDataMain {
	public static void main(String[] args) {
		OrderDao dao = new OrderDao();
		dao.addOrder(new Order("1", "Bike", "1"));
		dao.addOrder(new Order("2", "Glass", "1"));
		dao.addOrder(new Order("3", "Almonds", "2"));
		System.out.println(dao.filterBy("1"));
	}
}
