package com.crud.service;

import java.util.List;

import com.crud.model.CartItem;
import com.crud.model.ShoppingCart;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart sc);

	void save(CartItem cartItem);

	void delete(CartItem cartItem);

	CartItem findById(String id);

}
