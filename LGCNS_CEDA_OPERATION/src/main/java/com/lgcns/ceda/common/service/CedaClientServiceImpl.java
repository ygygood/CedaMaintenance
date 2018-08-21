package com.lgcns.ceda.common.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lgcns.ceda.manual.dao.CedaClientListDao;
import com.lgcns.ceda.manual.dao.CedaClientManualDao;

public class CedaClientServiceImpl implements CedaClientService{

	@Override
	public ArrayList getAllClientList() {
		// TODO Auto-generated method stub
		ArrayList result = null;
		String path =this.getClass().getResource("CedaClientServiceImpl.class").getPath();
		path = path.substring(0, path.lastIndexOf("/classes"));
		
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(path+"/spring/root-context.xml");
		
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		
		return new CedaClientListDao(dataSource).getAllClient();
//		
//		if(keyword.equals("")) { 
//			return new CedaClientManualDao(dataSource).getUserInfo();
//		}else {
//			logger.info("keyword 검색 시작"); 
//			return new CedaClientManualDao(dataSource).getUserInfo(keyword);
//		}
	
	}
	
}
