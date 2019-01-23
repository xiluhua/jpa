package com;

import java.util.Date;

import org.junit.Test;

import com.entity.Customer;

public class MainB1_save extends Main{
	
	/**
	 * 相当于 hibernate save
	 * 如果想自行设定 id，注解： 
	 *    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 * 否则会报错：
	 * 	  Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist: com.Customer
	 */
	@Test
	public void test() {
		Customer customer = new Customer();
		// 注解: @GeneratedValue(strategy=GenerationType.IDENTITY) 时可自行设定 id
		// customer.setId(40);  
		customer.setAge(19);
		customer.setEmail("555@163.com");
		customer.setLastName("四");
		customer.setCreatedTime(new Date());
		customer.setBirth(new Date());
        entityManager.persist(customer);
	}

}
