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
	
	<script type="text/javascript">
		$('#table').datagrid({
			url:"TableServlet?mark=a",
			toolbar : [ {
				text :"订桌", 
				iconCls : 'icon-add', 
				handler : function() {
					var checkeds = $('#table').datagrid('getChecked');
					console.info(checkeds);
					if($("#a").attr("value")==null || $("#a").attr("value")==""){
						alert("请登录在来订桌！");
						$.ajax({
							datatype : "json",
							success : function(result) {
								$('#table').datagrid('reload');
							}
						});
					}else{
						if(checkeds[0].tableStatus=="已使用"){
							alert("桌子已被使用！");
							console.info(checkeds[0].tableId);
							$.ajax({
								datatype : "json",
								success : function(result) {
									$('#table').datagrid('reload');
								}
							});
						}else{
							console.info(checkeds[0].tableId);
							for(var i=0 ; i< checkeds.length ; i++){
								console.info(checkeds[i]);
								$.ajax({
										url:"TableServlet?mark=add&id="+checkeds[i].tableId+" &userName="+$("#a").attr("value"),
										type : "POST",
										datatype : "json",
										success : function(result) {
											$('#table').datagrid('reload');
										}
								});
							}
						}
					}
				}
			}, '-', {
				text :"取消", 
				iconCls : 'icon-remove',
				handler : function() {
					var checkeds = $('#table').datagrid('getChecked');
					console.info(checkeds);
					if($("#a").attr("value")==null || $("#a").attr("value")==""){
						alert("请登录在来订桌！");
						$.ajax({
							datatype : "json",
							success : function(result) {
								$('#table').datagrid('reload');
							}
						});
					}else{
						if($("#a").attr("value")!=checkeds[0].userName){
							alert("不是你定的桌子！");
							console.info(checkeds[0].tableId);
							$.ajax({
								datatype : "json",
								success : function(result) {
									$('#table').datagrid('reload');
								}
							});
						}else{
							console.info(checkeds[0].tableId);
							for(var i=0 ; i< checkeds.length ; i++){
								$.ajax({
									url:"TableServlet?mark=delete&id="+checkeds[i].tableId+" &userName="+$("#a").attr("value"),
									type : "POST",
									datatype : "json",
									success : function(result) {
										$('#table').datagrid('reload');
									}
								});
							}
						}
					}
				}
			}],
			columns:[[
		        {field:'1',checkbox:true},
		        {field:'tableId',title:'id',width:'10%'},
		        {field:'tableName',title:'桌子名称',width:'10%'},
		        {field:'tableStatus',title:'桌子状态',width:'10%'},   
		        {field:'line',title:'line',width:'10%'},
		        {field:'rowa',title:'rowa',width:'10%'},
		        {field:'userName',title:'用户名',width:'10%'},
		        {field:'createTime',title:'创建时间',width:'10%'},
		        {field:'cz',title:'操作',width:'10%',formatter: function(value,row,index){
		        	console.info(row);
		        	if(row.tableStatus=='已使用'){
		        		return '<button onclick="cancel(\''+index+'\')">取消</button>';
		        	}else{
			        	return '<button onclick="desk(\''+index+'\')">订桌</button>';
		        	}
		        }},
		    ]],
			pagination:true,
			
		});
		function desk(index){
			//var checkeds = row;
			//console.info(row);
			 $('#table').datagrid('selectRow',index);//可不可以直接传那一行
			var checkeds = $('#table').datagrid('getSelected');
			console.info(checkeds);
			//var checkeds = $('#table').datagrid('getChecked'); */
			if($("#a").attr("value")==null || $("#a").attr("value")==""){
				alert("请登录在来订桌！");
				$.ajax({
					datatype : "json",
					success : function(result) {
						$('#table').datagrid('reload');
					}
				});
			}else{
				if(checkeds.tableStatus=="已使用"){
					alert("桌子已被使用！");
					console.info(checkeds[0].tableId);
					$.ajax({
						datatype : "json",
						success : function(result) {
							$('#table').datagrid('reload');
						}
					});
				}else{
					console.info(checkeds.tableId);
					$.ajax({
						url:"TableServlet?mark=add&id="+checkeds.tableId+" &userName="+$("#a").attr("value"),
						type : "POST",
						datatype : "json",
						success : function(result) {
							$('#table').datagrid('reload');
						}
					});
				}
			}
		}
		function cancel(index){
			 $('#table').datagrid('selectRow',index);//可不可以直接传那一行
			var checkeds = $('#table').datagrid('getSelected');
			//var checkeds = $('#table').datagrid('getChecked');
			if($("#a").attr("value")==null || $("#a").attr("value")==""){
				alert("请登录在来订桌！");
				$.ajax({
					datatype : "json",
					success : function(result) {
						$('#table').datagrid('reload');
					}
				});
			}else{
				if($("#a").attr("value")!=checkeds.userName){
					alert("不是你定的桌子！");
					console.info(checkeds.tableId);
					$.ajax({
						datatype : "json",
						success : function(result) {
							$('#table').datagrid('reload');
						}
					});
				}else{
					console.info(checkeds.tableId);
					$.ajax({
						url:"TableServlet?mark=delete&id="+checkeds.tableId+" &userName="+$("#a").attr("value"),
						type : "POST",
						datatype : "json",
						success : function(result) {
							$('#table').datagrid('reload');
						}
					});
				}
			}
		}
	</script>
</body>
</html>