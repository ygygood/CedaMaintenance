<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="com.lgcns.ceda.dataset.ClientInfo" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<style type="text/css">
	
		@import url(https://fonts.googleapis.com/css?family=Anton);
		
		body{
			background-image : url('/ceda/images/main_bg.gif');
			height : 100%;
			width : 70%;
			font-family : 'Anton', anton;
			
		}
		
		footer{
			position : absolute;
			bottom : 5%;
			left : 10%;
			font-size : 7px;
		}
		
		ul{
			list-style : none;
			margin : 0;
			padding : 0;
		}
		
		li{
			
		}
		
		.headerMenuBar{
			top : 100px;
			left : 20%;	
			float : left;
			display : inline-block;
			margin : 0;
			padding : 0;
		}
		
		.headerSubMenu li{
			float : left;
			list-style : none;
			position : relative;
		}
		
		.headerSubMenu ul{
			  background: #eee;
			  border: 1px solid silver;
			  display: none;
			  padding: 0;
			  position: absolute;
			  left: 0;
			  top: 100%;
			  width: 180px;
		}
		
		.headerMenuList{
			top : 10px;
			bottom : 0;
			left : 50px;
			margin : 0 auto;
			border : 1;
			float : left;
		}	
				
		.iframe{
			width : 142%;
			height : 800px;
			border : 0;
			margin-top : 50px;
			noresize;
			seamless;
		}
		
		.a{
			text-decoration : none;
		}
		
		.headerSubMenu ul li {float : none}
		.headerSubMenu ul ul { left: 100%; top: 0; }
		.headerSubMenu ul ul li {float:none; margin-right:20px;}
		
	</style>

</head>
<body>
	<script>
		$(function(){
			  $(".headerSubMenu li").hover(function(){
			    $('ul:first',this).show();
			  }, function(){
			    $('ul:first',this).hide();
			  });
			  $(".headerSubMenu>li:has(ul)>a").each( function() {
			    $(this).html( $(this).html()+'   ' );
			  });
			  $(".headerSubMenu ul li:has(ul)")
			    .find("a:first")
			    .append("<p style='float:right;margin:-3px'>&#9656;</p>");
		});
	</script>
	<!-- upside menu bar  --> 
	<header>
		<div class="headerMenuBar">
			<nav>
				<ul class="headerSubMenu">
					<li><a href="#"><img src="/ceda/images/client_menu.gif" alt="CEDA"/></a>
						<ul>
							<li><a href="#">CheckList</a>
								<ul>
									<li><a href="cedaCklstDocuEnroll.do" target="contentIframe">문서등록 실패 확인</a>
									<li><a href="#">2</a>
								</ul>
							</li>
							<li><a href="cedaCklistManual.do">Manual</a>
							</li>
							<li><a href="#">toDo</a>
								<ul>
									<li><a href="#">1</a>
									<li><a href="#">2</a>
								</ul>
							</li>
						</ul>
					</li>
					<li><a href="#"><img src="/ceda/images/client_menu.gif" alt="DESC"/></a>
						<ul>
								<li><a href="#">CheckList</a>
									<ul>
										<li><a href="#">1</a>
										<li><a href="#">2</a>
									</ul>
								</li>
								<li><a href="#">Manual</a>
									<ul>
										<li><a href="#">1</a>
										<li><a href="#">2</a>
									</ul>
								</li>
								<li><a href="#">toDo</a>
									<ul>
										<li><a href="#">1</a>
										<li><a href="#">2</a>
									</ul>
								</li>
						</ul>
					</li>
					<li><a href="#"><img src="/ceda/images/client_menu.gif" alt="Common"/></a>
						<ul>
							<li><a href="clientContact.do?page=init" target="contentIframe">고객사 연락처</a>
							</li>
							<li><a href="#">Manual</a>
								<ul>
									<li><a href="#">1</a>
									<li><a href="#">2</a>
								</ul>
							</li>
							<li><a href="#">toDo</a>
								<ul>
									<li><a href="#">1</a>
									<li><a href="#">2</a>
								</ul>
							</li>
						</ul>
					</li>
					<!--  
					<li class="headerMenuList"><a href="#"><img src="/ceda/images/client_menu.gif" alt="CEDA"/></a></li>
					<li class="headerMenuList"><a href="#"><img src="/ceda/images/client_menu.gif" alt="DESC"/></a></li>
					<li class="headerMenuList"><a href="cedaCklstDocuEnroll.do" target="contentIframe"><img src="/ceda/images/client_menu.gif" alt="Client"/></a></li>
					<li class="headerMenuList"><a href="clientContact.do?page=init" target="contentIframe"><img src="/ceda/images/client_menu.gif" alt="ETC"/></a></li>
					 -->
				</ul>
			</nav>
		</div>
	</header>
	
	<div class="iframeDiv" align="center" >
		<iframe class="iframe" name="contentIframe" src="http://www.homejjang.com"></iframe>
	</div>
	
</body>
</html>

