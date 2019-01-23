package com;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.jpa.QueryHints;
import org.junit.Test;

import com.entity.Customer;

public class MainC21_EhCacheQuery_sql extends Main{
	
	/**
	 * @return Customer
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		String jpql = "SELECT * FROM JPA_CUSTOMERS where id >= ?";
		Query query = entityManager.createNativeQuery(jpql,Customer.class).setHint(QueryHints.HINT_CACHEABLE, true);
		query.setParameter(1, 1);
		List<Customer> list = query.getResultList();
		System.out.println(list.size());
		
		query = entityManager.createNativeQuery(jpql,Customer.class).setHint(QueryHints.HINT_CACHEABLE, true);
		query.setParameter(1, 1);
		list = query.getResultList();
		System.out.println(list.size());
	}

}



