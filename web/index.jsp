<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>餐厅</title>
<script src="js/html5.js"></script>
<link rel="stylesheet" href="css/style.css">
<link id="color" rel="stylesheet" href="css/color1.css">
<link rel="stylesheet" type="text/css" 
	href="fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<link rel="stylesheet" href="css/mediaelementplayer.min.css" />
</head>

<body>
	<!--Header Part Start-->
	<header id="header" class="clearfix">
	<div class="headerstrip">
		 
		<div class="spiral"></div>
	</div>

	<div class="container clearfix">
		<a id="logo">
			<img src="images/logo.png" alt="Tasty Delicious Recipes">
		</a>
		<nav id="topnav">
		<ul>
			<li class="active"><a href="####"
				data-description="Main Start page">个人中心</a>
				<ul>
					<c:if test="${!empty userName }" var="name" scope="session">
					
						<li><a href="/setTheTable.jsp">订座</a></li>
						<li><a href="/front/userManage/consumptionRecord.jsp">消费记录</a></li>
						<li><a href="/orderForm.jsp">我的订单 </a></li>
						
					</c:if>
				</ul>
			</li>
			<li><a href="####" data-description="Main Start page" >菜系选择</a>
				<ul id="caixi">
					 <li><a href="####">湘菜</a></li>
					<li><a href="####">粤菜 </a></li>
					<li><a href="####">川菜 </a></li>
					<li><a href="#####">招牌菜 </a></li>
				</ul>
			</li>
			<li><a href="#####" data-description="Features of theme">产品特色</a>
				<ul>
					<li><a href="#####">优秀历史</a></li>
					<li class="submenu"><a href="####">店内优秀厨师</a></li>
				</ul>
			</li>
			<li><a href="front/userManage/index.jsp" data-description="Our Thought">用户登录</a>
				<ul>
					<li><a href="front/userManage/register.jsp" >注册用户</a></li>
					<c:if test="${!empty userName }" var="name" scope="session">
						<li><a href="front/userManage/userUpdata.jsp">修改密码</a></li>
						<li><a href="front/userManage/userDelete.jsp">注销用户</a></li>
					</c:if>
				</ul>
			</li>
			<li><a href="contact-us.html"data-description="Send enquiry here">联系我们</a>
				<ul>
					<li><font color="white">微信：12315985211</font></li>
					<li><font color="white">电话：12315985211</font></li>
				</ul>
			</li>
		</ul>
		</nav>
	</div>
	</header>
	<h1 class="topcontent">
		菜鸟餐厅 - <span>让生活更美好</span>
	</h1>
	<!--Header Part End-->

	<!--Slidr Part Start-->
	<section id="flexslider" class="clearfix">
	<div class="flexslider">
		<ul class="slides">
			<li><img src="images/sliderimg1.jpg" alt="" title="" />
				<p class="flex-caption">
					美好的一天 -<b> 从舌头开始 </b> <span
						class="second"> </span><br> <br> <span>&nbsp&nbsp 菜鸟餐厅——吃的不仅仅是食物
					</span>
				</p></li>
			<li><img src="images/sliderimg2.jpg" alt="" title="" />
				<p class="flex-caption">
					美好的一天 -<b> 从舌头开始 </b> <span
						class="second"> </span><br> <br> <span>&nbsp&nbsp 菜鸟餐厅——吃的不仅仅是食物
					</span>
				</p></li>
			<li><img src="images/sliderimg1.jpg" alt="" title="" />
				<p class="flex-caption">
					美好的一天 -<b> 从舌头开始 </b> <span
						class="second"> </span><br> <br> <span>&nbsp&nbsp 菜鸟餐厅——吃的不仅仅是食物
					</span>
				</p></li>
			<li><img src="images/sliderimg2.jpg" alt="" title="" />
				<p class="flex-caption">
					美好的一天 -<b> 从舌头开始 </b> <span
						class="second"> </span><br> <br> <span>&nbsp&nbsp 菜鸟餐厅——吃的不仅仅是食物
					</span>
				</p></li>
		</ul>
	</div>
	</section>
	<!--Slidr Part End-->
	<!-- <div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">Website Template</a>
	</div> -->
	<!--Middle Part Start-->
	<!--What's Hot Start-->
	<section id="maincontainer" class="container clearfix">
	<h1 class="heading1">
		<a href="/orderForm.jsp">我的订单</a>
		<button id="zhifu" >立即购买</button>
		 
	</h1>
	<!-- options --> <section id="options" class="clearfix">
	<ul id="filters" class="option-set clearfix" data-option-key="filter">
		<li><a href="#filter" data-option-value="*" class="selected" onclick="fun1()">所有类型</a></li>
		<li><a href="#filter" data-option-value=".Spicy" onclick="fun2()">小吃</a></li>
		<li><a href="#filter" data-option-value=".Cocktails" onclick="fun3()">酒水</a></li>
		<li><a href="#filter" data-option-value=".Snacks" onclick="fun4()">主食</a></li>
	</ul>
	</section> <!-- Recipea -->
	<div id="rec" >
	<ul id="ulc">
	</ul>
		
	</div>
	<div id="recipecontainer" class="clearfix recipecolumn3 recipesortable">
		 <ul id="ul">
			<li class="element Cocktails Sea-Food"><a
				href="recipeimg/recipeimg1big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg1.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title">黄瓜炒肉</a>
					<p>狗子令大厨专业打造，精心熬制250小时，保证吃了更他一样哈</p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div></li>
			<li class="element Cocktails Sea-Food Snacks"><a
				href="recipeimg/recipeimg2big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg2.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title">狗子π蔬菜沙拉</a>
					<p>狗子令大厨专业打造，摘取500米下臭水沟的老蔬菜</p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div></li>
			<li class="element Sea-Food Spicy Cocktails"><a
				href="recipeimg/recipeimg3big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg3.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title">这是什么鬼</a>
					<p>Lorem Ipsum has been the industry's standard dummy text ever
						since the 1500s.</p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div></li>
			<li class="element Snacks Snacks Spicy"><a
				href="recipeimg/recipeimg1big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg1.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title">这是什么东西</a>
					<p>Lorem Ipsum has been the industry's standard dummy text ever
						since the 1500s.</p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div></li>
			<li class="element Spicy Sea-Food Snacks"><a
				href="recipeimg/recipeimg2big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg2.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title">
						</a>
					<p></p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div></li>
			<li class="element  Cocktails Sea-Food"><a
				href="recipeimg/recipeimg3big.jpg" class="fancyboxpopup"><img
					src="recipeimg/recipeimg3.jpg" alt="" /></a>
				<div class="recipedetails">
					<a href="recipedetails.html" class="title"></a>
					<p></p>
					<ul class="rate">
						<li class="on"></li>
						<li class="on"></li>
						<li class="on"></li>
						<li class="off"></li>
						<li class="off"></li>
					</ul>
					<a class="fr" href="recipedetail.html">Read More >></a>
				</div>
			</li>
		</ul> 
	</div>
 	<!-- #container --> </section>
	<!--What's Hot End-->
	<!--Latest Event start-->
	<section id="middleline" class="clearfix">
	<div class="midlinebg">
		<div class="container">
			<div class="roungloog">
				<img src="images/roundimg.png" alt="" title="">
			</div>
			<h1 class="textpadding">新品特供</h1>
			<div class="event">
				<span class="eventdate">食品名称 : 香辣猪蹄</span>
				<span class="eventdate">价格:250元/份</span>
				<p>
					<strong>香辣猪蹄</strong> 是本店最近推出的一款主食，由国际顶级大师力做，让舌头有家的感觉
				</p>
			</div>
		</div>
	</div>
	</section>
	<!--Latest Event End-->
	<!--Middle container Start-->
	<section class="container clearfix"> <!--leftpart--> <section
		class="mb20 leftpart"> <article id="mostratedgallery"
		class="mb20 clearfix">
	<h1 class="heading1">香辣猪蹄</h1>
	<div class="mostrated">
		<a data-fancybox-group="mostratedgallery"
			title="Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			href="recipeimg/recipeimg1big.jpg"><img
			src="recipeimg/recipeimg1big.jpg" alt="" title="" /></a> <a
			data-fancybox-group="mostratedgallery" style="display: none"
			title="Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			href="recipeimg/recipeimg2big.jpg"><img
			src="recipeimg/recipeimg2big.jpg" alt="" title="" /></a> <a
			data-fancybox-group="mostratedgallery" style="display: none"
			title="Lorem ipsum dolor sit amet, consectetur adipiscing elit."
			href="recipeimg/recipeimg3big.jpg"><img
			src="recipeimg/recipeimg3big.jpg" alt="" title="" /></a>
	</div>
	<ul class="rate">
		<li class="on"></li>
		<li class="on"></li>
		<li class="on"></li>
		<li class="on"></li>
		<li class="on"></li>
	</ul>
	<br>
	<div class="widthcolumn3">
		<p>
			<strong>Lorem Ipsum</strong> is simply dummy text of the printing and
			typesetting industry. Lorem Ipsum has been the industry's standard
			dummy text ever since the 1500s, when an unknown printer took a
			galley of type and scrambled it to make a type specimen book. <br>
			<br> It has survived not only five centuries, but also the leap
			into electronic typesetting, remaining essentially unchanged. It was
			popularised in the 1960s with the release of Letraset sheets
			containing Lorem Ipsum passages, and more recently with desktop. in
			the 1960s with the release of Letraset sheets containing Lorem Ipsum
			passages, and more recently with desktop.
		</p>
		<a href="blog-single-gallery.html" class="linkbutton fr">立即购买</a>
	</div>

	<div class="receipedtailsnote">
		<h4 class="heading4 recipedetailtitle">食品成分</h4>
		<ul class="listoption3">
			<li>猪蹄 : <span class="bold">500g</span></li>
			<li>酱油 : <span class="bold">50g</span></li>
			<li>香菜 : <span class="bold">20g</span></li>
			<li>其他 : <span class="bold">若干</span></li>
		</ul>
	</div>
	<div class="clear"></div>

	</article> </section> <!--Sidebar start--> <aside class="blogright">
	<div class="sidecontainer">
		<h4 class="heading4">搜索</h4>
		<input type="text" class="blogserach"
			onBlur="if(this.value=='')this.value='请输入你要搜索的菜名';"
			onFocus="if(this.value=='请输入你要搜索的菜名')this.value='';"
			value="请输入你要搜索的菜名">
	</div>
	<div class="sidecontainer">
		<h4 class="heading4">精品推荐</h4>
		<ul class="archieve">
			<li><a href="#">水煮鱼</a></li>
			<li><a href="#">水煮鱼</a></li>
			<li><a href="#">水煮鱼</a></li>
			<li><a href="#">水煮鱼</a></li>
			<li><a href="#">水煮鱼</a></li>
			<li><a href="#">水煮鱼</a></li>
		</ul>
	</div>
	<div class="sidecontainer">
		<h4 class="heading4">相关</h4>
		<ul class="tabs">
			<li class="active"><a href="#tabdata1">流行</a></li>
			<li><a href="#tabdata2">历史</a></li>
			<li><a href="#tabdata3">相似</a></li>
		</ul>
		<div class="tabs-container">
			<div class="tabdata" id="tabdata1">
				<div class="popular">
					<ul class="popular">
						<li><img src="images/recipethumb1.jpg" alt=""> <a
							href="#" class="entrytitle">Best Recipe of the World...</a>
							<div class="entry-meta">
								<span class="published">May 5, 2012</span> <span
									class="meta-sep">·</span> <span class="comment-count"><a
									href="#">3 Comments</a> </span>
								<ul class="rate">
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="off"></li>
								</ul>
							</div></li>
						<li><img src="images/recipethumb2.jpg" alt=""> <a
							href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
							<div class="entry-meta">
								<span class="published">May 5, 2012</span> <span
									class="meta-sep">·</span> <span class="comment-count"><a
									href="#">3 Comments</a> </span>
								<ul class="rate">
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="off"></li>
								</ul>
							</div></li>
						<li><img src="images/recipethumb3.jpg" alt=""> <a
							href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
							<div class="entry-meta">
								<span class="published">May 5, 2012</span> <span
									class="meta-sep">·</span> <span class="comment-count"><a
									href="#">3 Comments</a> </span>
								<ul class="rate">
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="on"></li>
									<li class="off"></li>
								</ul>
							</div></li>
					</ul>
				</div>
			</div>
			<div class="tabdata" id="tabdata2">
				<ul class="popular">
					<li><img src="images/recipethumb2.jpg" alt=""> <a
						href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
						<div class="entry-meta">
							<span class="published">May 5, 2012</span> <span class="meta-sep">·</span>
							<span class="comment-count"><a href="#">3 Comments</a> </span>
							<ul class="rate">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="off"></li>
							</ul>
						</div></li>
					<li><img src="images/recipethumb3.jpg" alt=""> <a
						href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
						<div class="entry-meta">
							<span class="published">May 5, 2012</span> <span class="meta-sep">·</span>
							<span class="comment-count"><a href="#">3 Comments</a> </span>
							<ul class="rate">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="off"></li>
							</ul>
						</div></li>
				</ul>
			</div>
			<div class="tabdata" id="tabdata3">
				<ul class="popular">
					<li><img src="images/recipethumb1.jpg" alt=""> <a
						href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
						<div class="entry-meta">
							<span class="published">May 5, 2012</span> <span class="meta-sep">·</span>
							<span class="comment-count"><a href="#">3 Comments</a> </span>
							<ul class="rate">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="off"></li>
							</ul>
						</div></li>
					<li><img src="images/recipethumb1.jpg" alt=""> <a
						href="#" class="entrytitle">Best Recipe of the World...</a>
						<div class="entry-meta">
							<span class="published">May 5, 2012</span> <span class="meta-sep">·</span>
							<span class="comment-count"><a href="#">3 Comments</a> </span>
							<ul class="rate">
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="off"></li>
							</ul>
						</div></li>
					<li><img src="images/recipethumb3.jpg" alt=""> <a
						href="#" class="entrytitle">Lorem ipsum dolor Lorem ipsum...</a>
						<div class="entry-meta">
							<span class="published">May 5, 2012</span> <span class="meta-sep">·</span>
							<span class="comment-count"><a href="#">3 Comments</a> </span>
							<ul class="rate">
								<li class="on"></li	>
								<li class="on"></li>
								<li class="on"></li>
								<li class="on"></li>
								<li class="off"></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</div>
	</div>

	</aside> <!--Sidebar end--> </section>

	<!--Javascripts-->
	<script src="js/jquery-latest.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/jquery.isotope.min.js"></script>
	<script src="js/mediaelement-and-player.min.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="js/jquery.elastislide.js"></script>
	<script type="text/javascript" src="js/jquery.tweet.js"></script>
	<script type="text/javascript"
		src="fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
	<script type="text/javascript"
		src="fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<!-- <script type="text/javascript"
		src="http://maps.google.com/maps/api/js?sensor=false"></script> -->
	<script type="text/javascript" src="js/jquery.gmap.js"></script>
	<script src="js/jflickrfeed.min.js"></script>
	<!-- <script type="text/javascript" src="jquery.js"></script> -->
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript">
	

	
	
	$.ajax({
	    type: "POST",
	    url: "MenuServlet",
	    success: function(msg){
		 var list=JSON.parse(msg);
		 for(var i=0;i<list.length;i++){
			   var img=$("<li class='element Cocktails Sea-Food' style='display：inline-block'><a href="
					   +list[i].picture+" class='fancyboxpopup'><img src="+list[i].picture
					   +" width='300px' height='300px'></a><div class='recipedetails'><a href='recipedetails.html' class='title'>"
					   +list[i].menuName+"</a><p>"+list[i].describe+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+list[i].price+
"元一份</p>  <a class='fr' onclick=selects("+list[i].menuId+") >来一份 ></a>   </div></li>");
/* 			   var img=$("<li class='element Cocktails Sea-Food'><a href="+list[i].picture+" class='fancyboxpopup'><img src="+list[i].picture+" width='300px' height'300px'></a><div class='recipedetails'><a href='recipedetails.html' class='title'>"+list[i].menuName+"</a><p>"+list[i].describe+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+list[i].price+"元一份</p><a class='fr'  href='OrderdishesMenu?select=getSelectMenu&menuId="+list[i].menuId+"' >来一份 ></a></div></li>");
 */			   $("#ulc").append(img);
		 } 	 
	    }
	});
	 
	
	function selects(menuId){
 
		 $.ajax({
			url:"OrderdishesMenu?select=getSelectMenu",
			data:{
				id:menuId
			},
			success:function (){
				alert("已加入到我的的订单");
			}
		})
		
		
		
	}
	
	 
	
	
	
	
	$.ajax({
	    type: "POST",
	    url: "CookingServlet?select=query",
	    success: function(msg){
		 var list=JSON.parse(msg);
		 for(var i=0;i<list.length;i++){
			 var li=$("<li ><a href=\"TransitServlet?name="+list[i].vegetableName+"\">"+list[i].vegetableName+"</a></li>"); 
			 $("#caixi").append(li);
		 }
	    }
	});
	
	function fun1(){
		$("#ulc li").show("1000");
	}
	function fun2(){
		$.ajax({
		    type: "POST",
		    url: "MenuServlet",
		    success: function(msg){
			 var list=JSON.parse(msg);
			 for(var i=0;i<list.length;i++){
				  if(list[i].menuType=="小吃"){
					  $("#ulc>li:eq("+i+")").show("1000");
				  }else {
					  $("#ulc>li:eq("+i+")").hide("1000");
				  }
			 }
		    }
		});		
	}
	function fun3(){
		$.ajax({
		    type: "POST",
		    url: "MenuServlet",
		    success: function(msg){
			 var list=JSON.parse(msg);
			 for(var i=0;i<list.length;i++){
				  if(list[i].menuType=="酒水"){
					  $("#ulc>li:eq("+i+")").show("1000");
				  }else {
					  $("#ulc>li:eq("+i+")").hide("1000");
				  }
			 }
		    }
		});		
	}
	function fun4(){
		$.ajax({
		    type: "POST",
		    url: "MenuServlet",
		    success: function(msg){
			 var list=JSON.parse(msg);
			 for(var i=0;i<list.length;i++){
				  if(list[i].menuType=="主食"){
					  $("#ulc>li:eq("+i+")").show("1000");
				  }else {
					  $("#ulc>li:eq("+i+")").hide("1000");
				  }
			 }
		    }
		});		
	}

	
	

	</script>
</body>
</html>
