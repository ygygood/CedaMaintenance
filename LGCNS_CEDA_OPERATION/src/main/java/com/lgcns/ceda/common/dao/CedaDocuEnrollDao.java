package com.lgcns.ceda.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lgcns.ceda.dataset.ClientDocuEnrollInfo;

public class CedaDocuEnrollDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CedaDocuEnrollDao.class);
	private DataSource dataSource;
	
	public CedaDocuEnrollDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<ClientDocuEnrollInfo> getDocuEnrollFromTo(String fromDate, String toDate) {
		
		Connection conn;
		String sql = "SELECT PERSON_ID, REQUEST_IP, CREATE_DATE, ERROR_MSG, ALL_MESSAGE FROM TB_WS_CLIENT_ERRLOG WHERE 1=1 "
				   + "AND CLIENT_DATE >= '"+fromDate+"000000' "
				   + "AND CLIENT_DATE <= '"+toDate+"235959' "
				   + "ORDER BY CREATE_DATE, PERSON_ID ASC ";
		
		ArrayList<ClientDocuEnrollInfo> result = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			logger.info("query:"+sql);
			
			result = new ArrayList<ClientDocuEnrollInfo>();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(new ClientDocuEnrollInfo(rs.getString("PERSON_ID"),rs.getString("REQUEST_IP"),rs.getString("ERROR_MSG"),rs.getString("CREATE_DATE"),rs.getString("ALL_MESSAGE")));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
