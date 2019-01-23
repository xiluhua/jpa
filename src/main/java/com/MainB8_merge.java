package com;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;
import com.statics.Cons;

public class MainB8_merge extends Main{
	
	/**
	 * 相当于 hibernate merge
	 * 2. 游离对象 - id 不为空的对象
	 * 1). 若在 EntityManager 缓存中有该对象
	 * 3). JPA 会把当前游离‘对象的属性’复制到‘缓存中的对象’中
	 * 4). 对‘缓存中的对象’执行 update 操作
	 */
	@Test
	public void test() {
		Customer customer1 = new Customer(43, "五流", 21);
		
		Customer customer2 = entityManager.find(Customer.class, 43);
		
		Customer customer3 = entityManager.merge(customer1);
		
		System.out.println("customer1: "+customer1);
		System.out.println("customer2: "+customer2);
		System.out.println("customer3: "+customer3);
		System.out.println("customer1: "+JSON.toJSONStringWithDateFormat(customer1, Cons.DATETIME1));
		System.out.println("customer2: "+JSON.toJSONStringWithDateFormat(customer2, Cons.DATETIME1));
		System.out.println("customer3: "+JSON.toJSONStringWithDateFormat(customer3, Cons.DATETIME1));
	}

}



