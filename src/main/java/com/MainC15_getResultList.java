package com;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.statics.Cons;

public class MainC15_getResultList extends Main{
	
	/**
	 * @return List<Object[]>
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
		String jpql = "select lastName,email from Customer where age > ?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);
		List list = query.getResultList();
		System.out.println("list: "+list);
		System.out.println("size: "+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			Object[] arr = (Object[])list.get(i);
			System.out.println("arr[0]: "+arr[0]);
			System.out.println("arr[1]: "+arr[1]);
		}
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			Object[] arr = (Object[])list.get(i);
			System.out.println((i+1)+": "+JSON.toJSONStringWithDateFormat(arr, Cons.DATETIME1));
		}
	}

}



