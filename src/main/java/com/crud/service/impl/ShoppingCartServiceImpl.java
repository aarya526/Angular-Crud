package com.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.ShoppingCart;
import com.crud.repository.ShoppingCartRepository;
import com.crud.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository sRepository;

	@Override
	public ShoppingCart findByIpAddress(String ipAddress) {
		return sRepository.findByIpAddress(ipAddress);
	}

	@Override
	public void save(ShoppingCart sp) {
		// TODO Auto-generated method stub
		sRepository.save(sp);

	}

}
