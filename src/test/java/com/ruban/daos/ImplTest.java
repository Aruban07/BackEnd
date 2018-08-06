package com.ruban.daos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruban.dconfigurations.DBCongfigurations;
import com.ruban.product1.Products;

import junit.framework.TestCase;

public class ImplTest extends TestCase
{
ApplicationContext context= new AnnotationConfigApplicationContext(DBCongfigurations.class,Impl.class);
Dao prodao=(Dao)context.getBean("impl");
	
	public void testSaveProduct()
	{
		
	}

	
	public void testGetProduct() 
	{
	Products pro1=prodao.getProduct(2);
	Products pro2=prodao.getProduct(1);
	Products pro3=prodao.getProduct(3);
	assertNotNull(pro1);
	assertNotNull(pro2);
	assertNotNull(pro3);
	
	double exp=100;
	double actual=pro1.getPrice();
	assertTrue(exp!=actual);
	}

}
