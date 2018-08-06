package com.ruban.daos;

import java.util.List;

import com.ruban.product1.Products;

public interface Dao {
Products saveProduct(Products prod);
Products getProduct(int id);
void uppro(Products pro);
void del(int id);
List<Products> getAllProducts();
}
