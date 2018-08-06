package com.ruban.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruban.dconfigurations.DBCongfigurations;
import com.ruban.product1.Products;

import junit.framework.TestCase;

public class ImplTest1 extends TestCase {
	ApplicationContext context= new AnnotationConfigApplicationContext(DBCongfigurations.class,Impl.class);
	Dao prodao=(Dao)context.getBean("impl");
	
	public void testSaveProduct()
	{
		Products prod = new Products();
	       prod.setPrice(1001);
	       prod.setProdes("blue");
	       prod.setProname("water");
	       prod.setQuan(101);	
	       prod=prodao.saveProduct(prod);
	       assertTrue(prod.getId()>0);
	}

	public void testGetProduct() {
	
	}

	
	public void testUppro() 
	{
	Products pro1=prodao.getProduct(2);
	pro1.setPrice(250);
	pro1.setQuan(7);
	prodao.uppro(pro1);
	assertTrue(pro1.getPrice()==250);
	}
	
	public void testGetAllProducts()
	{
	List<Products> prods=prodao.getAllProducts();
	assertTrue(prods.size()>0);
	assertFalse(prods.isEmpty());
	}

}
