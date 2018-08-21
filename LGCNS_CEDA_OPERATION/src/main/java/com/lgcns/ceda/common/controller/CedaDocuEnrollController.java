package com.lgcns.ceda.common.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lgcns.ceda.HomeController;
import com.lgcns.ceda.common.service.CedaClientServiceImpl;
import com.lgcns.ceda.common.service.CedaDocuEnrollServiceImpl;
import com.lgcns.ceda.dataset.ClientDocuEnrollInfo;

@Controller
public class CedaDocuEnrollController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public String getDocuResult(Model model, String fromDate, String toDate) {
		
		logger.info("com.lgcns.ceda.common.controller.CedaDocuEnrollController.getDocuResult("+fromDate+","+toDate+")");
		
		// get all of clients list
//		ArrayList<String> clientsList = new ArrayList<String>();
//		clientsList = new CedaClientServiceImpl().getAllClientList();
		
		String fDate = fromDate;
		String tDate = toDate;
		
		logger.info("abc");;
		
		ArrayList<ClientDocuEnrollInfo> docuEnrollResult = new CedaDocuEnrollServiceImpl().getDocuEnrollResult(fDate, tDate);
		model.addAttribute("docuEnrollResult",docuEnrollResult);
		
		return "cedaDocuResult";
	}
}
