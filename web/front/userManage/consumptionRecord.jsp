<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--jquery文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<!--easyui核心文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<!--对应的语言包-->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<!--皮肤文件-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<!--图标文件-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body>
	<table id="dg"></table>
	<script type="text/javascript">
		$('#dg').datagrid({
		    url:'/restaurant/userServlet?judge=record',
		    columns:[[
		        {field:'i',checkbox:true},
		        {field:'recordId',hidden:true},
		        {field:'userName',title:'用户名',width:"33%"},
		        {field:'consumptionMoney',title:'消费金额',width:"33%"},
		        {field:'time',title:'消费时间',width:"33%"}
		    ]],
		    pagination:true
		});
		$('#dg').datagrid({
			toolbar: [{
				iconCls: 'icon-remove',
				handler: function(){
					var allData = $("#dg").datagrid("getSelections");
					console.info(allData);
					var array = new Array();
					for(var i in allData){
						array[i]=allData[i].recordId;
					}
					console.info(array);
					$.ajax({
						url: "/restaurant/userServlet",
						data:"judge=recrodDelete&data="+array,
						success:function(message){
							$('#dg').datagrid('reload');    
						}
					})
				}
			},'-',{
				iconCls: 'icon-help',
				handler: function(){alert('选择左边的框可以进行删除')}
			}]
		});

	</script>
</body>
</html>