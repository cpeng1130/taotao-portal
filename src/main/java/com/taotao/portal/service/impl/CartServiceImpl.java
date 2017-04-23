package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.ItemService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ItemService itemService;
	@Value("${COOKIE_EXPIRE}")
	private Integer COOKIE_EXPIRE;
	@Override
	public TaotaoResult addCart(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
		boolean haveFlg=false;
		List<CartItem> itemList = getCartItemList(request);
		for(CartItem cartItem :itemList){
			if(cartItem.getId().longValue()==itemId){
				if(cartItem.getNum()==null){
					cartItem.setNum(0+num);
				}
				//cartItem.setNum(cartItem.getNum()+num);
				haveFlg=true;
				break;
			}
			
		}
		if(!haveFlg){
			TbItem item = itemService.getItemById(itemId);
			CartItem cartItem = new CartItem();
			cartItem.setId(itemId);
			cartItem.setNum(num);
			cartItem.setPrice(item.getPrice());
			cartItem.setTitle(item.getTitle());
			if(StringUtils.isNoneBlank(item.getImage())){
				String image = item.getImage();
				String[] strings = image.split(",");
				cartItem.setImage(strings[0]);
			}
			itemList.add(cartItem);
		}
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList),COOKIE_EXPIRE,true);
		
		return TaotaoResult.ok();
	}
	
	private List<CartItem> getCartItemList(HttpServletRequest request) {

		try {
			String json = CookieUtils.getCookieValue(request, "TT_CART", true);
			List<CartItem> list = JsonUtils.jsonToList(json, CartItem.class);
			return list==null? new ArrayList<CartItem>():list;
		} catch (Exception e) {
			return new ArrayList<CartItem>();
		}

	}
	
	public List<CartItem> getCartItems(HttpServletRequest request){
		List<CartItem> list = getCartItemList(request);
		return list;
	}
}
