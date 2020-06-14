package com.crud.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Product;
import com.crud.repository.ProductRepository;
import com.crud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findById(String id) {

//		for (Product p : Product.products) {
//
//			if (p.getId() == id) {
//
//				return p;
//			}
//
//		}
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product save(Product product) {

//		Product existingProduct = findById(product.getId());
//		if (existingProduct == null) {
//
//			
//			return product;
//
//		}
		return productRepository.save(product);
	}

	@Override
	public void delete(Product product) {

//		Product.products.remove(product);
		productRepository.delete(product);

	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
//		return Product.products;
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public void update(Product product) {

		log.info("Product Id {}", product.getId());
//		for (Product p : Product.products) {
//
//			if (p.getId() == product.getId()) {
//
//				p.setProductName(product.getProductName());
//				p.setBrand(product.getBrand());
//				p.setQuantity(product.getQuantity());
//				p.setListPrice(product.getListPrice());
//				p.setOurPrice(product.getOurPrice());
//				p.setDescription(product.getDescription());
//
//			}
//
//		}
		productRepository.save(product);

	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}

}
