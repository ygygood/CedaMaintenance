package com.lgcns.ceda.manual.controller;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.lgcns.ceda.dataset.ClientInfo;
import com.lgcns.ceda.manual.service.CedaClientManualServiceImpl;

@Controller
public class CedaClientManualController {
	
	private static final Logger logger = LoggerFactory.getLogger(CedaClientManualController.class);
	
	public String getClientInfo(Model model, String page, ArrayList <String>searchKeyword) {
		
		logger.debug("com.lgcns.ceda.manual.CedaManualController.getClientInfo()");
		logger.debug("page:"+page);
		
		ArrayList<ClientInfo> result = new ArrayList<ClientInfo>();
		
		if(page.equals("init")) {					// init page(no search)
			model.addAttribute("getUserInfo",result);
			return "clientContact";
		}else if(page.equals("search")) {					// keyword search
			result = new CedaClientManualServiceImpl().getClientInfo(searchKeyword);
			model.addAttribute("getUserInfo",result);
			return "clientContact";
		}else {
			return "commonoErr";
		}
	}
	
	
}
