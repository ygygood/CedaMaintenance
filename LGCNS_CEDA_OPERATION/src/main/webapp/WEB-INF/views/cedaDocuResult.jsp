<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="com.lgcns.ceda.dataset.ClientDocuEnrollInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문서등록 실패 모니터링</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="/ceda/resources/css/demo.css"/>
<link rel="stylesheet" href="/ceda/resources/css/theme1.css"/>

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
</style>
<script type="text/javascript">
	$(document).ready(function(event){
		(function($){
/*			var events = [
				  {'Date': new Date(2016, 6, 7), 'Title': 'Doctor appointment at 3:25pm.'},
				  {'Date': new Date(2016, 6, 18), 'Title': 'New Garfield movie comes out!', 'Link': 'https://garfield.com'},
				  {'Date': new Date(2016, 6, 27), 'Title': '25 year anniversary', 'Link': 'https://www.google.com.au/#q=anniversary+gifts'},
				];
				var settings = {};
				var element = document.getElementById('caleandar');
				caleandar(element, events, settings)	*/

		})(jQuery)
		
	});
	
	function openCalendar(){
		var datepicker = new DatePickk();
		datepicker.show();
	}
</script>
</head>
  <body>
    <!-- div id="caleandar">
    </div>

    <script type="text/javascript" src="js/caleandar.js"></script -->
    <%
    	ArrayList<ClientDocuEnrollInfo> searchResult = (ArrayList<ClientDocuEnrollInfo>)request.getAttribute("docuEnrollResult");
		int resultLength;
		if(searchResult == null){
			resultLength = 0;
		}else{
			resultLength = searchResult.size();
	//		int fromDate = Integer.parseInt((String)request.getAttribute("fromDate"));
	//		int to = Integer.parseInt((String)request.getAttribute("toDate"));
		}
		
	%>
    <form action="cedaCklstDocuEnroll.do">
	    <table class="searchTable" border="1">
	    	<tr>
	    		<td>Date</td>
	    		<td><input type="text" class ="dateText" name="fromDate" size="6"></input></td>
	    		<td><input type="text" class ="dateText" name="toDate" size="6"></input></td>
	    		<td><input type="submit" class="search" name="search" value="search"/></td>
	    	</tr>
	    </table>
    </form>
    
    <table class="resultTable" border="1" >
    		<tr align="center">
    			<td width="150">Company</td>
    			<td width="150">IP</td>
    			<td width="150">Create_Date</td>
    			<td width="150">Error_Message</td>
    			<td width="150">All_Message</td>
    		</tr>
 
 		   		<% 
				if(resultLength==0){
					%> <tr align="center"><td colspan="10">NO RESULT</td></tr>
				<%}else{
					for(int i=0;i<resultLength;i++){
						%>	<tr align="center">
								<td><%= searchResult.get(i).getCompany_name() %></td>
								<td><%= searchResult.get(i).getIp() %></td>
								<td><%= searchResult.get(i).getCreation_date() %></td>
								<td><%= searchResult.get(i).getError_msg() %></td>
								<td><%= searchResult.get(i).getAll_msg() %></td>
							</tr>
				<%	}	
				  }
				%>
 
    </table>


    
  </body>
</html>