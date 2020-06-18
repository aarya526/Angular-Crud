package com.crud.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.CartItem;
import com.crud.model.Product;
import com.crud.model.ShoppingCart;
import com.crud.service.CartItemService;
import com.crud.service.ProductService;
import com.crud.service.ShoppingCartService;

@RestController
@RequestMapping("/sc")
public class ShoppingCartRestController {

	@Autowired
	private ShoppingCartService scService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ProductService productService;

	@GetMapping("/count")
	public int countCartItems(HttpServletRequest request) {

		String ipAddress = request.getRemoteAddr();
		int count = 0;
		ShoppingCart sc = scService.findByIpAddress(ipAddress);
		if (sc == null) {

			ShoppingCart sc1 = new ShoppingCart();
			sc1.setIpAddress(ipAddress);
			sc1.setGrandTotal(new BigDecimal(0));
			scService.save(sc1);
			return count;

		} else {

			List<CartItem> items = cartItemService.findByShoppingCart(sc);
			for (CartItem c : items) {
				count = count + c.getRequestQty();
			}
			System.out.println("Count : " + count);
			return count;

		}

	}

	@PostMapping("/addToCart")
	public ResponseEntity<?> addToCart(@RequestParam String id, HttpServletRequest request) {

		Product product = productService.findById(id);
		ShoppingCart sc = scService.findByIpAddress(request.getLocalAddr());
		List<CartItem> cartItems = cartItemService.findByShoppingCart(sc);
		for (CartItem c : cartItems) {

			if (c.getProduct().getId().equals(product.getId())) {

				System.out.println("Already Added!");
				return new ResponseEntity<String>("Item Already Added!", HttpStatus.OK);

			}

		}

		CartItem c = new CartItem();
		c.setProduct(product);
		c.setRequestQty(1);
		c.setSc(sc);
		sc.setGrandTotal(
				sc.getGrandTotal().add(new BigDecimal(c.getProduct().getOurPrice()).multiply(new BigDecimal(1))));
		cartItemService.save(c);
		scService.save(sc);
		System.out.println("Item Successfully Added!");
		return new ResponseEntity<String>("Cart Item Added!", HttpStatus.OK);

	}

}
