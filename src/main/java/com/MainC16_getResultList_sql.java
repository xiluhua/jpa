package com;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;

public class MainC16_getResultList_sql extends Main{
	
	/**
	 * @return Customer
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c.* ");
		jpql.append("FROM JPA_CUSTOMERS c,");
		jpql.append("	  JPA_ADDRESSES a ");
		jpql.append("WHERE c.age > ? and c.addr_id = a.id");
		Query query = entityManager.createNativeQuery(jpql.toString(),Customer.class);
		query.setParameter(1, 1);
		List<Customer> list = ((List<Customer>)query.getResultList());
		System.out.println("list: "+JSON.toJSONString(list));
		System.out.println("size: "+list.size());
	}

}



