<!doctype html>

<html lang="ko">
<head>
	<title>LG CNS</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<style type="text/css">
		@import url(https://fonts.googleapis.com/css?family=Anton);

		html, body{
			height:90%;
		}
		
		body{
			background-image : url('/ceda/images/login_bg.gif');
			vertical-align : middle;
			color : white;
			font-family : 'Anton',anton;
		}
		
		footer{
			position : absolute;
			bottom : 5%;
			left : 10%;
			font-size : 7px;
		}
		
		h1{
			font-size : 50px;
			text-align : center;
		}
		
		tr, td{
		 padding : 3px;
		}
		
		#loginForm{
			position: absolute;
			top : 45%;
			left : 40%;
		}
		
		#loginTable {
			width : 35%;
			text-align : center;
			margin : auto;
		}	
		
	</style>
	
	 <script type="text/javascript">

	 $(document).ready(function(){
			(function($){
				$('#loginForm').submit(function(event){
					if($('#id').val() == "" || $('#pwd').val() == ""){
						alert('please check id and password');
					}else{
						$('#loginForm').attr('action','login.do').attr('method','get').submit();
					}
				});
			 })(jQuery)			
	 });	
		
	 </script>
</head>
<body>
	<header><h1>LG CNS CEDA OPERTAION SYSTEM</h1></header>
	<section>
			<form id="loginForm">
		 		<table id="loginTable" style="border:1px solid gray;">
			 		<tr>
			 			<td> <label>I  D</label></td>
			 			<td> <input type="text" name="id" value=''/> </td>
			 		</tr>
			 		<tr>
			 			<td> <label> PASSWORD </label> </td>
			 			<td> <input type="password" name="pwd" value=''/> </td>
			 		</tr>
		 		</table>
		 		<input type="image" src="/ceda/images/login.gif" name="submit" value="submit" height="30px" width="258px" alt="submit"/>
		 	</form>
	</section>
	<footer>copyright</footer>
</body>
</html>
