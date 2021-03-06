package com.taotao.portal.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.service.StaticPageService;

@Controller
public class StaticPageController {

	@Autowired
	private StaticPageService staticPageService;
	@RequestMapping("/gen/item/{itemId}")
	@ResponseBody
	public TaotaoResult getItemPage(@PathVariable Long itemId){
		try{
			TaotaoResult result = staticPageService.genItemHtml(itemId);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return TaotaoResult.build(500 , ExceptionUtils.getStackTrace(e));
		}
		
	}
}
