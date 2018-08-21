package com.lgcns.ceda.manual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lgcns.ceda.dataset.ClientInfo;
import com.lgcns.ceda.manual.controller.CedaClientManualController;

public class CedaClientManualDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CedaClientManualDao.class);
	private DataSource dataSource;
	
	public CedaClientManualDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<ClientInfo> getUserInfo( ) {
		return null;
	}
	
	public ArrayList<ClientInfo> getUserInfo(String keyword) {
		
		// temproray sql
		String sql = "SELECT * FROM TB_CONTACT_INFO WHERE 1=1 AND (COMPANY_NAME LIKE '%"+keyword+"%' OR CLIENT_NAME LIKE '%"+keyword+"%') ";	
		Connection conn = null;
		ArrayList<ClientInfo> queryResult;
	
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(2, keyword);
//			ps.setString(3, keyword);
			logger.info("query:"+sql);
			ResultSet rs = ps.executeQuery();
			queryResult = new ArrayList<ClientInfo>();
			
			while(rs.next()) {
				logger.info(rs.getString("DIV")+"/"+rs.getString("COMPANY_NAME")+"/"+rs.getString("CLIENT_NAME"));
				queryResult.add(new ClientInfo(rs.getString("DIV"),rs.getString("COMPANY_NAME"),rs.getString("CLIENT_NAME"),rs.getString("POSITION"),rs.getString("PHONE"),rs.getString("TEL"),rs.getString("EMAIL"),rs.getString("ROLE"),rs.getString("PM_INFORM"),rs.getString("SERVICE")));
			}
			
			return queryResult;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
