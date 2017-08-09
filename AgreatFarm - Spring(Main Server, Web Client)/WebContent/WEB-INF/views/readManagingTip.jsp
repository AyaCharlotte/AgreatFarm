<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
	HttpSession httpSession = request.getSession();
	String m_num = (String)httpSession.getAttribute("m_num");
	String m_email = (String)httpSession.getAttribute("m_email");
	String m_nickname = (String)httpSession.getAttribute("m_nickname");
	String m_farmer = (String)httpSession.getAttribute("m_farmer");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>AgreatFarm Main</title>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
		<style>
			body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
			body {font-size:16px;}
			.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
			.w3-half img:hover{opacity:1}
		</style>
	    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" 
	    crossorigin="anonymous"></script>
	    <script src="resources/js/managingTipBoard.js" type="text/javascript" charset="UTF-8"></script>
	    
	    <script>
	    	var userNumber = <%=Integer.parseInt(m_num)%>;
	    	
	    	
	    	$(function(){
	    		readManagingTipContent(10);
	    	});
	    	
	    	function readManagingTipContent(mId){
	    		$.ajax({
	    			url:"/AgreatFarm/readManagingTipContent/" + mId,
	    			success: function(data, status){
	    				console.log(data, typeof(data));
	    			},
	    			error: function(e){
	    				console.log(e);
	    			}
	    		});
	    	}

	    	
	    	
	    </script>
	</head>
	<body>
    	<!-- Sidebar/menu -->
		<nav class="w3-sidebar w3-green w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
			<a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
			<div class="w3-container">
				<h3 class="w3-padding-64"><b>Agreat Farm</b></h3>
			</div>
			<div class="w3-bar-block">
				<a href="/AgreatFarm/main" class="w3-bar-item w3-button w3-hover-white">축사관리</a>
				<a href="/AgreatFarm/managing" class="w3-bar-item w3-button w3-hover-white">축사운영 Tip</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-white">축사중고거래장터</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-white">축산뉴스</a>
			</div>
    	</nav>

		<!-- Top menu on small screens -->
		<header class="w3-container w3-top w3-hide-large w3-green w3-xlarge w3-padding">
			<a href="javascript:void(0)" class="w3-button w3-green w3-margin-right" onclick="w3_open()">=</a>
			<span>Agreat Farm</span>
		</header>

		<!-- Overlay effect when opening sidebar on small screens -->
		<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
		
		<!-- !PAGE CONTENT! -->
		<div id="main_content" class="w3-main" style="margin-left:340px;margin-right:40px">
			<!-- Header -->
			WHAT
   			<!-- End page content -->
   		</div>
   		
		<script>
		// Script to open and close sidebar
			function w3_open() {
			    document.getElementById("mySidebar").style.display = "block";
			    document.getElementById("myOverlay").style.display = "block";
			}
			
			function w3_close() {
			    document.getElementById("mySidebar").style.display = "none";
			    document.getElementById("myOverlay").style.display = "none";
			}
		// Modal Image Gallery
		</script>
	</body>
</html>
