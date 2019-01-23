package com;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;
import com.statics.Cons;

public class MainC14_getResultList extends Main{
	
	/**
	 * @return List<Customer>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		String jpql = "from Customer c where c.age > ?";
		Query query = entityManager.createQuery(jpql, Customer.class);
		query.setParameter(1, 1);
		List<Customer> list = query.getResultList();
		System.out.println("list: "+list);
		System.out.println("size: "+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+": "+JSON.toJSONStringWithDateFormat(list.get(i), Cons.DATETIME1));
		}
	}

}



