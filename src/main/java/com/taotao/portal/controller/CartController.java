package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId, Integer num,HttpServletRequest request,HttpServletResponse response){
		TaotaoResult result = cartService.addCart(itemId, num, request, response);
		return "cart-success";
	}
	@RequestMapping("/cart/cart")
	public String showCartList(HttpServletRequest request,Model model){
		List<CartItem> list = cartService.getCartItems(request);
		model.addAttribute("cartList",list);
		return "cart";
	}
}
