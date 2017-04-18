package com.taotao.portal.service;

import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
@Service
public interface StaticPageService {

	TaotaoResult genItemHtml(Long itemId)throws Exception;
}
