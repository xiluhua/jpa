package com;

import javax.persistence.Query;

import org.junit.Test;

public class MainC23_update extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		String jpql = "update Customer set lastName='来来' where id = ?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 33);
		int result = query.executeUpdate();
		System.out.println("result: "+result);
	}

}



