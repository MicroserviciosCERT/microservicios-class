package com.certificatic.springboot.app.item.models.service;

import java.util.List;

import com.certificatic.springboot.app.item.models.Item;

public interface ItemService {

	
	public Item findById(Long id, Integer cantidad);
}
