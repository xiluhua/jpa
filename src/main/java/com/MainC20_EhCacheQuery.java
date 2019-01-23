package com;

import javax.persistence.Query;

import org.hibernate.jpa.QueryHints;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC20_EhCacheQuery extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		String jpql = "SELECT * FROM JPA_CUSTOMERS where last_Name = ?";
		Query query = entityManager.createNativeQuery(jpql,Customer.class).setHint(QueryHints.HINT_CACHEABLE, true);
		query.setParameter(1, "二弄的");
		Customer customer = (Customer)query.getSingleResult();
		System.out.println(JSON.toJSONString(customer));
		
		query = entityManager.createNativeQuery(jpql,Customer.class).setHint(QueryHints.HINT_CACHEABLE, true);
		query.setParameter(1, "二弄的");
		customer = (Customer)query.getSingleResult();
		System.out.println(JSON.toJSONString(customer));
	}

}



