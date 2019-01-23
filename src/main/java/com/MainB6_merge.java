package com;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.Customer;
import com.statics.Cons;

public class MainB6_merge extends Main{
	
	/**
	 * 相当于 hibernate merge
	 * 2. 游离对象 - id 不为空的对象
	 * 1). 若在 EntityManager 缓存中没有该对象
	 * 2). 若在数据库中也没有对应的记录
	 * 3). JPA 会创建一个新的对象，然后把当前游离对象的属性复制到新创建的对象中
	 * 4). 对新创建的对象执行 save 操作
	 * 			即：先执行查询看库里有没有，不存在就执行 save
	 */
	@Test
	public void test() {
		Customer customer1 = new Customer(400, "五四", 21);
		Customer customer2 = entityManager.merge(customer1);
		System.out.println("customer1: "+JSON.toJSONStringWithDateFormat(customer1, Cons.DATETIME1));
		System.out.println("customer2: "+JSON.toJSONStringWithDateFormat(customer2, Cons.DATETIME1));
	}

}
