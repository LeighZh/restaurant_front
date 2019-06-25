<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--jquery文件-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!--easyui核心文件-->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!--对应的语言包-->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!--皮肤文件-->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<!--图标文件-->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
</head>
<body>
	<table id ="table" border="10"></table>
	
	<p id="a" style="display: none;" value=${userName } ></p>
	
	<div id="dd" style="display: none;" align="center">
		<p>编号:<input id="a" type="text" style="width:300px">
		<p>名称:<input id="b" type="text" style="width:300px">
		<p>价格:<input id="c" type="text" style="width:300px">
		<p><input type="button" value="提交" id="tj">
		<input type="button" value="重置" id="cz">
	</div> 
	<div id="bb" style="display: none;">
	
	
		 好评<input type="radio" name="lick"  value="好评" checked="checked" /><br>
		 中评<input type="radio" name="lick" value="中评" /><br>
		  差评<input type="radio" name="lick"  value="差评" /><br>
		评论 :<textarea rows="" cols="" id="text"></textarea>
		 
		  
		
	
		 
	</div>  
	<script type="text/javascript">
		$('#table').datagrid({
			url:"IndentServlet?mark=a&userName="+$("#a").attr("value"),
				 toolbar:[{
					text : "结账",
					iconCls : 'icon-add',
					handler : function(){
						var checkeds = $('#table').datagrid('getChecked');
						console.info(checkeds.indentId);
						if(checkeds[0].status=="未结账"){
							for(var i=0 ; i< checkeds.length ; i++){
								$.ajax({
									url:"IndentServlet?mark=delete&indentId="+checkeds[i].indentId+"&money="+checkeds[i].money+" &userName="+$("#a").attr("value"),
									type : "POST",
									datatype : "json",
									success : function(result) {
										$('#table').datagrid('reload');
									}
								});
							}
						}else{
							alert("你选择有不为未结账的订单");
							$.ajax({
								datatype : "json",
								success : function(result) {
									$('#table').datagrid('reload');
								}
							});
						}
					}
				}, '-', {
					text : "取消",
					iconCls : 'icon-add',
					handler : function(){
						var checkeds = $('#table').datagrid('getChecked');
						console.info(checkeds.indentId);
						if(checkeds[0].status=="未结账"){
							for(var i=0 ; i< checkeds.length ; i++){
								$.ajax({
									url:"IndentServlet?mark=cancel&indentId="+checkeds[i].indentId+" &userName="+$("#a").attr("value"),
									type : "POST",
									datatype : "json",
									success : function(result) {
										$('#table').datagrid('reload');
									}
								});
							}
						}else{
							alert("你选择有不为未结账的订单");
							$.ajax({
								datatype : "json",
								success : function(result) {
									$('#table').datagrid('reload');
								}
							});
						}
					}
				}],
				columns:[[ 
					{field:'1',checkbox:true},
					{field:'indentId',title:'订单id',width:'10%'},
					{field:'indentName',title:'订单名',width:'10%'},
					{field:'menuName',title:'菜名',width:'10%'},
					{field:'userName',title:'订单用户',width:'10%'},
					{field:'indentTime',title:'订单时间',width:'10%'},
					{field:'status',title:'订单状态',width:'10%'},
					{field:'money',title:'金额',width:'10%'},
					{field:'cz',title:'操作',width:'10%',formatter: function(value,row,index){
			        	if(row.status=='未结账'){
			        		return '<button onclick="settleAccounts(\''+index+'\')">结账</button><button onclick="cancel(\''+index+'\')">取消</button>';
			        	}else if(row.status=="已结账"){
			        		return '<button onclick="evaluate1(\''+index+'\') ">点评</button>';
			        	}
			        }},
				]],
			pagination:true,
		});
		
		
		
		
		
		function evaluate1(index){
			
			 
			$('#table').datagrid('selectRow',index);
			
			
			
			var checkeds = $('#table').datagrid('getSelected');//这一行 
			
			
			
			
			$('#bb').dialog({
			    title: '好评奖励5元',    
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    cache: false,
			    modal: true,
			    buttons:[{
					text:'确定',
					handler:function(){
						
						$.ajax({ 
							url:"OrderdishesMenu?select=ping",
							data:{ 
							menuName:checkeds.menuName,
							ping:$("[name=lick]:checked").val(),
							text:$("#text").val()
							}, 
							 success:function (){
								 alert("评论成功");
								 
								 $('#bb').window('close');
								 
								 $("#table").datagrid('reload');
							 }
							
						})
					 
					
					}
				},{
					text:'关闭',
					handler:function(){}
				}]
			    
			    
			}); 
			 
			
		 
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		function settleAccounts(index){
			 $('#table').datagrid('selectRow',index);
				var checkeds = $('#table').datagrid('getSelected');
				console.info(checkeds.indentId);
				$.ajax({
					url:"IndentServlet?mark=delete&indentId="+checkeds.indentId+"&money="+checkeds.money+" &userName="+$("#a").attr("value"),
					type : "POST",
					datatype : "json",
					success : function(result) {
						$('#table').datagrid('reload');
					}
				});
		}
		function cancel(index){
			 $('#table').datagrid('selectRow',index);
				var checkeds = $('#table').datagrid('getSelected');
				console.info(checkeds);
				$.ajax({
					url:"IndentServlet?mark=cancel&indentId="+checkeds.indentId+" &userName="+$("#a").attr("value"),
					type : "POST",
					datatype : "json",
					success : function(result) {
						$('#table').datagrid('reload');
					}
				});
		}
	</script>
</body>
</html>