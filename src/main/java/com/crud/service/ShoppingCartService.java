package com.crud.service;

import com.crud.model.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart findByIpAddress(String ipAddress);

	void save(ShoppingCart sp);

}
