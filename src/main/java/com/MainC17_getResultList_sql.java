package com;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.query.Customer2;

public class MainC17_getResultList_sql extends Main{
	
	/**
	 * @return Customer
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c.id,c.last_name as lastName,a.city,c.createdTime as createTime ");
		jpql.append("FROM JPA_CUSTOMERS c,");
		jpql.append("	  JPA_ADDRESSES a ");
		jpql.append("WHERE c.age > ? and c.addr_id = a.id");
		Query query = entityManager.createNativeQuery(jpql.toString(),Customer2.class);
		query.setParameter(1, 1);
		List<Customer2> list = query.getResultList();
		System.out.println(JSON.toJSONString(list));
	}

}



