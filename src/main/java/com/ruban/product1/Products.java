package com.ruban.product1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String proname;
private String prodes;
private int quan;
private double price;
public int getId()
{
return id;
}
public String getProname() 
{
	return proname;
}
public void setProname(String proname) 
{
	this.proname = proname;
}
public String getProdes() 
{
	return prodes;
}
public void setProdes(String prodes) 
{
	this.prodes = prodes;
}
public int getQuan() 
{
	return quan;
}
public void setQuan(int quan) 
{
	this.quan = quan;
}
public double getPrice() 
{
	return price;
}
public void setPrice(double price) 
{
	this.price = price;
}
public void setId(int id) 
{
	this.id = id;
}
}
