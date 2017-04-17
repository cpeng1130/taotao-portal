package com.taotao.portal.service;

import org.springframework.stereotype.Service;

import com.taotao.pojo.TbItem;

@Service
public interface ItemService {

	TbItem getItemById(Long itemId);
	String getItemDescById(long itemId);
	String getItemParamById(Long itemId);
}
