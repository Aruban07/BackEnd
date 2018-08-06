package com.ruban.producttab;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ruban.daos.Dao;
import com.ruban.daos.Impl;
import com.ruban.dconfigurations.DBCongfigurations;
import com.ruban.product1.Products;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(DBCongfigurations.class,Impl.class);
        Dao dap= (Dao)context.getBean("impl");
        List<Products> prods=dap.getAllProducts();
        for(Products p:prods)
        {
        	System.out.println(p.getId()+"  "+ p.getProname()+"  "+ p.getProdes()+"  " +p.getPrice()+"  ");
        }
        Products prod = new Products();
       prod.setPrice(105);
       prod.setProdes("product2");
       prod.setProname("pencil2");
       prod.setQuan(15);
    dap.saveProduct(prod);
    }
}
