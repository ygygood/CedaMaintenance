package com.lgcns.ceda.common.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lgcns.ceda.common.dao.CedaDocuEnrollDao;
import com.lgcns.ceda.dataset.ClientDocuEnrollInfo;

public class CedaDocuEnrollServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(CedaDocuEnrollServiceImpl.class);
	
	public ArrayList<ClientDocuEnrollInfo> getDocuEnrollResult(String fromDate, String toDate) {
		
		String path =this.getClass().getResource("CedaDocuEnrollServiceImpl.class").getPath();
		path = path.substring(0, path.lastIndexOf("/classes"));
		
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(path+"/spring/root-context.xml");
		DataSource dataSource = (DataSource) applicationContext.getBean("arcadmin");
		ArrayList<ClientDocuEnrollInfo> docuEnrollResult = new CedaDocuEnrollDao(dataSource).getDocuEnrollFromTo(fromDate, toDate);
		
//		return checkEnrollResult(clientList, docuEnrollResult);
		return docuEnrollResult;
	}
	
//	public HashMap<String,ClientDocuEnrollInfo> checkEnrollResult(ArrayList<String> clientList, ArrayList<ClientDocuEnrollInfo> enrollResult) {
//		
//		HashMap<String, ClientDocuEnrollInfo> docuEnrollResult = new HashMap<String, ClientDocuEnrollInfo> ();
//		logger.info("clientList:"+clientList.toString());
//		logger.info("enrollResult:"+enrollResult.toString());
//		// init HashMap
//		for(int i=0; i<clientList.size(); i++) {
//			docuEnrollResult.put(clientList.get(i), null);
//		}
//	
//		for(int i=0; i<enrollResult.size(); i++) {
//			docuEnrollResult.put(enrollResult.get(i).getCompany_name(), enrollResult.get(i));
//		}
//		logger.info("docuEnrollResult:"+docuEnrollResult.toString());
//		
//		return docuEnrollResult;
//	}
}
