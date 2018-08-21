<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="com.lgcns.ceda.dataset.ClientInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Contact</title>
<style type="text/css">
	
	@import url(https://fonts.googleapis.com/css?family=Anton);

	html, body{
		height:90%;
	}
		
	body{
		font-family : 'Anton',anton;
	}

	.resultTable{
		color : white;
	}
	
	.search{
		background-color: orange;
		border: none;
		box-shadow: none;
		color: #fff;
		text-transform: uppercase;
		cursor: pointer;
		padding: 4px 6px;
		padding: 0.4rem 0.6rem;
		margin-left: 5px;
		width: auto;
	}
	
	.searchTable{
		color : white;
	}
	
	.searchKeyword{
		background-color : #0100FF ;
	}
	

</style>
</head>
<body>
<%
	ArrayList<ClientInfo> searchResult = (ArrayList<ClientInfo>)request.getAttribute("getUserInfo");
	int resultLength;
	if(searchResult == null){
		resultLength = 0;
	}else{
		resultLength = searchResult.size();
	}
%>
	<form action="clientContact.do">
		<input type="hidden" name="page" value="search"/>
		<table class="searchTable" border="1">
			<tr>
				<td>KEYWORD</td>
				<td><input type="text" name="keyword" id="searchKeyword" maxlength="20" /></td>
				<td><input type="submit" class="search" name="search" value="search"/></td>
			</tr>
		</table>
	</form>
	
	<!-- result of search -->
	<table border="1" class="resultTable">
		<tr align="center">
			<td width="150">DIV</td>
			<td width="150">COMPANY_NAME</td>
			<td width="150">NAME</td>
			<td width="150">POSITION</td>
			<td width="150">PHONE</td>
			<td width="150">TEL</td>
			<td width="150">EMAIL</td>
			<td width="150">ROLE</td>
			<td width="150">PM_INFORM</td>
			<td width="150">SERVICE</td>
		</tr>
			<% 
				if(resultLength==0){
					%> <tr align="center"><td colspan="10">NO RESULT</td></tr>
			<%	}else{
					for(int i=0;i<resultLength;i++){
						%>	<tr align="center">
								<td><%= searchResult.get(i).getDivision() %></td>
								<td><%= searchResult.get(i).getCompanyName() %></td>
								<td><%= searchResult.get(i).getName() %></td>
								<td><%= searchResult.get(i).getPosition() %></td>
								<td><%= searchResult.get(i).getPhone() %></td>
								<td><%= searchResult.get(i).getTel() %></td>
								<td><%= searchResult.get(i).getEmail() %></td>
								<td><%= searchResult.get(i).getRole() %></td>
								<td><%= searchResult.get(i).getPmInform() %></td>
								<td><%= searchResult.get(i).getService() %></td>
							</tr>
			<%		}	
				}
			%>
	</table>
</body>
</html>