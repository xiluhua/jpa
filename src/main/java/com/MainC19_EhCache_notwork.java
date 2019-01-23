package com;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC19_EhCache_notwork extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		Customer customer1 = entityManager.find(Customer.class, 30);
		System.out.println(JSON.toJSONString(customer1));
		
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println();
		
		Customer customer2 = entityManager2.find(Customer.class, 30);
		System.out.println(JSON.toJSONString(customer2));
	}

}



