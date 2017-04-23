package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

@Service
public interface CartService {

	TaotaoResult addCart(Long itemId,Integer num,HttpServletRequest request,HttpServletResponse response);
	List<CartItem> getCartItems(HttpServletRequest request);
}
