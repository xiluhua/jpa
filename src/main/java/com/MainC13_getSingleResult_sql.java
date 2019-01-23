package com;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC13_getSingleResult_sql extends Main{
	
	/**
	 * @return Customer
	 */
	@Test
	public void test() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c.* ");
		jpql.append("FROM JPA_CUSTOMERS c,");
		jpql.append("     JPA_ADDRESSES a ");
		jpql.append("WHERE c.last_Name = ? ");
		jpql.append("  and c.addr_id = a.id");
		Query query = entityManager.createNativeQuery(jpql.toString(),Customer.class);
		query.setParameter(1, "二弄的");
		Customer customer = (Customer)query.getSingleResult();
		System.out.println(JSON.toJSONString(customer));
	}

}



