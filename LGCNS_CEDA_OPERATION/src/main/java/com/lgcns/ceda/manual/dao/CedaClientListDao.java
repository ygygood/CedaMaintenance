package com.lgcns.ceda.manual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class CedaClientListDao {
	
	private DataSource dataSource;
	
	public CedaClientListDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<String> getAllClient() {
		
		Connection conn;
		String sql = "SELECT USER_ID FROM TB_USER WHERE 1=1 "
				    + "AND USER_ID NOT LIKE ON ('%donga%','%test%','%master%','%storm%','%ascan%','%ds_%')";
		
		ArrayList<String> result = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			result = new ArrayList<String>();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString("USER_ID"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
