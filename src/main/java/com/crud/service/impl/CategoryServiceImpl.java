package com.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static List<String> categories = new ArrayList<String>();

	@Override
	public List<String> categories() {

		List<String> category = new ArrayList<String>();
		category.add("Smartphones");
		category.add("Laptop");
		category.add("Tablets");
		category.add("Accessories");
		categories = category;
		return categories;
	}

}
