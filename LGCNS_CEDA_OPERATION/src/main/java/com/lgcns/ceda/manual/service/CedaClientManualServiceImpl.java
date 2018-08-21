package com.lgcns.ceda.manual.service;

import java.util.ArrayList;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lgcns.ceda.dataset.ClientInfo;
import com.lgcns.ceda.manual.controller.CedaClientManualController;
import com.lgcns.ceda.manual.dao.CedaClientManualDao;

public class CedaClientManualServiceImpl implements CedaClientManualService{
	
	private static final Logger logger = LoggerFactory.getLogger(CedaClientManualServiceImpl.class);
	
	@Override
	public ArrayList<ClientInfo> getClientInfo(ArrayList<String> keywordList) {
		// TODO Auto-generated method stub
		
		logger.info(keywordList.toString());
		
		String keyword = keywordList.get(0);
		String path =this.getClass().getResource("CedaClientManualServiceImpl.class").getPath();
		path = path.substring(0, path.lastIndexOf("/classes"));
		
		logger.info("keyword:"+keyword);
		
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(path+"/spring/root-context.xml");
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		
		if(keyword.equals("")) { 
			return new CedaClientManualDao(dataSource).getUserInfo();
		}else {
			logger.info("keyword 검색 시작"); 
			return new CedaClientManualDao(dataSource).getUserInfo(keyword);
		}
	}
}
