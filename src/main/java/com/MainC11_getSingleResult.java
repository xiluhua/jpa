package com;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC11_getSingleResult extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		String jpql = "from Customer where lastName = ?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, "二弄的");
		Customer customer = (Customer)query.getSingleResult();
		System.out.println(JSON.toJSONString(customer));
	}

}



