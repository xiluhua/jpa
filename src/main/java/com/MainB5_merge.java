package com;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;
import com.statics.Cons;

public class MainB5_merge extends Main{
	
	/**
	 * 相当于 hibernate merge
	 * 1. 临时对象 - id 为空的对象
	 * 会创建一个新的对象，把临时对象的属性复制到新的对象中，然后做 save 操作。
	 * 所以新的对象有 id，而临时对象没有 id
	 */
	@Test
	public void test() {
		Customer customer1 = new Customer("李四", 20);
		Customer customer2 = entityManager.merge(customer1);
		System.out.println("customer1: "+JSON.toJSONStringWithDateFormat(customer1, Cons.DATETIME1));
		System.out.println("customer2: "+JSON.toJSONStringWithDateFormat(customer2, Cons.DATETIME1));
	}

}
