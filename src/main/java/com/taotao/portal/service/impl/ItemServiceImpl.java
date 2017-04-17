package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.PortalItem;
import com.taotao.portal.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_ITEM_BASE_URL}")
	private String REST_ITEM_BASE_URL;
	@Override
	public TbItem getItemById(Long itemId) {
		String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_BASE_URL+itemId);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, PortalItem.class);
		TbItem item = (TbItem) taotaoResult.getData();
		return item;
	}

}
