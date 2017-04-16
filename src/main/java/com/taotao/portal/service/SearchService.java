package com.taotao.portal.service;

import org.springframework.stereotype.Service;

import com.taotao.portal.pojo.SearchResult;

@Service
public interface SearchService {
	SearchResult search(String keyword,int page,int rows);
}
