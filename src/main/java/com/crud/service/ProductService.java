package com.crud.service;

import java.util.List;

import com.crud.model.Product;

public interface ProductService {

	Product findById(String id);

	Product save(Product product);

	void update(Product product);

	void delete(Product product);

	List<Product> listAll();

	List<Product> findByCategory(String category);

}
