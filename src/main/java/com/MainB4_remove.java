package com;

import org.junit.Test;

public class MainB4_remove extends Main{
	
	/**
	 * 相当于 hibernate delete
	 * 只能删除持久化对象，而 hibernate 可以删除游离对象
	 */
	@Test
	public void test() {
		// 会报错：java.lang.IllegalArgumentException: Removing a detached instance com.Customer#31
		// 只能删除持久化对象
		// entityManager.remove(new Customer(31));
		// 1. 可以跑
		entityManager.createQuery("delete from Customer where id = 32").executeUpdate();
		
		// 2. 可以跑
//		Customer customer = entityManager.find(Customer.class, 31);
//		entityManager.remove(customer);
		
	}

}
