package com.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.CartItem;
import com.crud.model.ShoppingCart;
import com.crud.repository.CartItemRepository;
import com.crud.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cRepository;

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart sc) {
		// TODO Auto-generated method stub
		return cRepository.findBySc(sc);
	}

	@Override
	public void save(CartItem cartItem) {
		// TODO Auto-generated method stub
		cRepository.save(cartItem);

	}

	@Override
	public void delete(CartItem cartItem) {
		// TODO Auto-generated method stub
		cRepository.delete(cartItem);

	}

	@Override
	public CartItem findById(String id) {
		// TODO Auto-generated method stub
		return cRepository.findById(id).orElse(null);
	}

}
