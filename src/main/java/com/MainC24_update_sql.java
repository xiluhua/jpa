package com;

import javax.persistence.Query;

import org.junit.Test;

public class MainC24_update_sql extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		String jpql = "update JPA_CUSTOMERS set last_name='来了' where id = ?";
		Query query = entityManager.createNativeQuery(jpql);
		query.setParameter(1, 33);
		int result = query.executeUpdate();
		System.out.println("result: "+result);
	}

}



