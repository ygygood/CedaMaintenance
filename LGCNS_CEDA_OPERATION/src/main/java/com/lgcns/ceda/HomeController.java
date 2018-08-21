package com.lgcns.ceda;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgcns.ceda.common.controller.CedaDocuEnrollController;
import com.lgcns.ceda.common.controller.CedaLoginController;
import com.lgcns.ceda.manual.controller.CedaClientManualController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(@RequestParam String id,  @RequestParam String pwd, Model model) {
		return new CedaLoginController().login(id, pwd, model);
	}
	
	@RequestMapping(value="/cedaCklstDocuEnroll.do", method = RequestMethod.GET)
	public String cedaCklstDocuEnroll(HttpServletRequest request, Model model) {
		
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
				
		return new CedaDocuEnrollController().getDocuResult(model,fromDate,toDate);
		
	}
	
	@RequestMapping(value="/cedaCklstManual.do", method=RequestMethod.GET)
	public String cedaCklstManual(HttpServletRequest request, Model model){
		
		return null;
	}
	
	
	@RequestMapping(value="/clientContact.do", method = RequestMethod.GET)
	public String clientInfo(HttpServletRequest request, Model model ) {
		CedaClientManualController cedaClientManualController = new CedaClientManualController();
		
		String page = request.getParameter("page");
		
		if(page.equals("init")) {
			return cedaClientManualController.getClientInfo(model, page, null);
		}else if(page.equals("search")) {
			ArrayList<String> keywordList = new ArrayList<String>();
			String keyword = request.getParameter("keyword");
			keywordList.add(0,keyword);
	
			return cedaClientManualController.getClientInfo(model, page, keywordList);
		}
		
		return "clientContact";
	}
}
