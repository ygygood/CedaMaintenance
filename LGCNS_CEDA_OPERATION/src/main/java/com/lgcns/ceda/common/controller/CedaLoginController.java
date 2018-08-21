package com.lgcns.ceda.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.lgcns.ceda.HomeController;
import com.lgcns.ceda.common.service.CedaLoginServiceImpl;

@Controller
public class CedaLoginController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public String login( String id,  String pwd, Model model) {
		
		logger.info("com.lgcns.ceda.common.controller.CedaLoginController.login("+id+")");
				
		boolean loginResult = new CedaLoginServiceImpl().getLoginResult(id, pwd);
		logger.info("loginResult:"+loginResult);
		if(loginResult) {
			model.addAttribute("id",id);	
			return "main";
		}else {
			return "loginErr";
		}
	}
}

