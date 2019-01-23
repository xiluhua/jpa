package com;

import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC18_EhCache extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		Customer customer1 = entityManager.find(Customer.class, 30);
		System.out.println(JSON.toJSONString(customer1));
		
		transaction.commit();
		entityManager.close();
		
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Customer customer2 = entityManager.find(Customer.class, 30);
		System.out.println(JSON.toJSONString(customer2));
	}

}



