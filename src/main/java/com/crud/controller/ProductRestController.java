package com.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Product;
import com.crud.service.CategoryService;
import com.crud.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	private static final Logger log = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	ObjectMapper om = new ObjectMapper();

	// ============ Retrieve Categories ==========

	@GetMapping("/categories")
	public String listCategories() throws Exception {

		List<String> cats = categoryService.categories();
		String c = om.writeValueAsString(cats);
		return c;

	}

	@GetMapping("/category/{category}")
	public ResponseEntity<?> listProductByCategory(@PathVariable String category) {

		List<Product> products = productService.findByCategory(category);
		if (products.size() == 0) {

			return new ResponseEntity<String>("No Product Found", HttpStatus.BAD_REQUEST);

		} else {

			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}

	}

	// ===============Retrieve All Products==============

	@GetMapping("/all")
	public String listAllProducts() throws Exception {

		List<Product> products = productService.listAll();
		String s = om.writeValueAsString(products);
		System.out.println(s);
		return s;

	}

	// ===============Retrieve Single Product==============

	@GetMapping("/{id}")
	public ResponseEntity<?> getSingleProduct(@PathVariable String id) {

		Product product = productService.findById(id);
		if (product == null) {

			log.info("Product With Id {} Not Found", id);
			return new ResponseEntity<String>("No Product Found", HttpStatus.NOT_FOUND);

		} else {

			log.info("Product Details : {}", product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

	}

	// ===============Save Product==============

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product, BindingResult br) {

		if (product.getListPrice() < product.getOurPrice()) {

			br.addError(new FieldError("product", "ourPrice", "our price cannot be greater than list price"));

		}
		if (br.hasErrors()) {

			Map<String, String> errors = new HashMap<String, String>();
			br.getFieldErrors().forEach(fr -> {

				errors.put(fr.getField(), fr.getDefaultMessage());

			});
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);

		}
//		else if (product.getListPrice() < product.getOurPrice()) {
//
//			FieldError fe = new FieldError("product", "ourPrice", "our price cannot be greater than list price");
//			Map<String, String> errors = new HashMap<String, String>();
//			errors.put(fe.getField(), fe.getDefaultMessage());
//			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
//
//		} 
		else {
			productService.save(product);
			log.info("Product Successfully Saved with ID : {}", product.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

	}

	// ===============Update Single Product==============

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, BindingResult br) {

		if (product.getListPrice() < product.getOurPrice()) {

			br.addError(new FieldError("product", "ourPrice", "our price cannot be greater than list price"));

		}
		if (br.hasErrors()) {

			Map<String, String> errors = new HashMap<String, String>();
			br.getFieldErrors().forEach(fr -> {

				errors.put(fr.getField(), fr.getDefaultMessage());

			});
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
//		else if (product.getListPrice() < product.getOurPrice()) {
//
//			FieldError fe = new FieldError("product", "ourPrice", "our price cannot be greater than list price");
//			Map<String, String> errors = new HashMap<String, String>();
//			errors.put(fe.getField(), fe.getDefaultMessage());
//			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
//
//		}
		else {
			productService.update(product);
			log.info("Product Successfully Update with ID : {}", product.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

	}

	// ===============Delete Single Product==============

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable String id) {

		Product product = productService.findById(id);
		if (product == null) {

			log.info("Product With Id {} Not Found", id);
			return new ResponseEntity<String>("No Product Found", HttpStatus.NOT_FOUND);

		} else {

			productService.delete(product);
			log.info("Product with Id {} Successfully Deleted!", id);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}

	}

}
