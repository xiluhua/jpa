package com;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.Customer;

/**
 * helloworld
 * @author xilh
 * @20190119
 */
public class Main {

    EntityManagerFactory entityManagerFactory;
    // 类似于 hibernate 里的 sessionFactory
    // 注意： 二级缓存仅适用于当前 entityManager
	EntityManager entityManager;
	// 反例。注意：二级缓存不会起作用
	EntityManager entityManager2;
	EntityTransaction transaction;
	EntityTransaction transaction2;
	
	@Before
	public void before() {
		// 1. 创建 EntityManagerFactory		
		String persistenceUnitName = "jpa-1";
	    // EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql",true);
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName, properties);
        
		// 2. 创建 EntityManager，类似于 hibernate 里的 sessionFactory
		entityManager  = entityManagerFactory.createEntityManager();
		entityManager2 = entityManagerFactory.createEntityManager();
		System.out.println("entityManager : "+entityManager);
		System.out.println("entityManager2: "+entityManager2);
		
		// 3. 开启事务
		transaction = entityManager.getTransaction();
		transaction.begin();
		
		transaction2 = entityManager2.getTransaction();
		transaction2.begin();
		
	}
	
	@After
	public void after() {
		if (transaction.isActive()) {
			transaction.commit();
		}
		if (transaction2.isActive()) {
			transaction2.commit();
		}
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setAge(19);
		customer.setEmail("555@163.com");
		customer.setLastName("二");
		customer.setCreatedTime(new Date());
		customer.setBirth(new Date());
        entityManager.persist(customer);
	}

}
