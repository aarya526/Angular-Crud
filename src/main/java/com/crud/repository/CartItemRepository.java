package com.crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.CartItem;
import com.crud.model.ShoppingCart;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, String> {

	List<CartItem> findBySc(ShoppingCart sc);

}
