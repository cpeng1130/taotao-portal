package com.taotao.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.taotao.pojo.TbUser;

@Service
public interface UserService {

	TbUser getUserByToken(HttpServletRequest request,HttpServletResponse response);
}
