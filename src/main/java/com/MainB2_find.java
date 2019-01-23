package com;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;
import com.statics.Cons;

public class MainB2_find extends Main{
	
	/**
	 * 相当于 hibernate get，不是懒加载
	 */
	@Test
	public void test() {
		Customer customer = entityManager.find(Customer.class, 30);
		System.out.println("------------------------------------");
		String json       = JSON.toJSONStringWithDateFormat(customer, Cons.DATETIME1);
		System.out.println(json);
	}

}
