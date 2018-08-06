package com.ruban.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ruban.product1.Products;
@Repository
@Transactional
public class Impl implements Dao{
@Autowired
private SessionFactory sessionfactory;
public Products saveProduct(Products prod)
{
	Session sess=sessionfactory.getCurrentSession();
	System.out.println("beffore "+prod.getId());
	sess.save(prod);
	System.out.println("after "+prod.getId());
	return prod;
}
public Products getProduct(int id)
{
	Session sess=sessionfactory.getCurrentSession();
	Products prod=(Products)sess.get(Products.class, id);
	return prod;
}
public void uppro(Products pro)
{
Session sess=sessionfactory.getCurrentSession();
sess.update(pro);
}
public void del(int id)
{
	Session sess=sessionfactory.getCurrentSession();
	Products prod=(Products)sess.get(Products.class,id);
if(prod!=null)
	sess.delete(prod);
}
public List<Products> getAllProducts()
{
Session sess=sessionfactory.getCurrentSession();
Query query=sess.createQuery("from Products");
List<Products>prods=query.list();
return prods;
}
}