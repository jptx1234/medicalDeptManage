<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>物品包类别维护</title> 

<link href="css/base.css" rel="stylesheet">
<link rel="stylesheet" href="../custom/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="../custom/uimaker/icon.css">
<link rel="stylesheet" href="css/providers.css">
<style>
	
	#ff input.textbox-text{
		height: 33px;
		width: 80%;
		line-height: 33px;
	}
	
</style>
</head> 
<body>
	<div id="tb" style="padding:0 10px;">
		<form id="query">
       	 姓名: <input class="easyui-textbox" id="name" type="text" name="name" value="" style="width:166px;height:35px;line-height:35px;" />
        <a href="javascript:;" id="qryBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="javascript:;" id="resetBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
        <div style="float: right;">
        	<a href="javascript:;" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">新增</a>
        	<a href="javascript:;" id="deleteBtn" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
        </div>
        </form>
      </div>
    <div class="container">
       <table id="dg" style="width:100%;" title="人员管理">
            <thead>
                <tr>
                    <th field="id" data-options="halign: 'center', align:'center', checkbox: true" style="width: 5%;">选择</th>
                    <th field="staffName" data-options="halign: 'center', align:'center'" style="width: 10%;">姓名</th>
                    <th field="staffEname" data-options="halign: 'center', align:'center'" style="width: 10%;">登录名</th>
                    <th field="sex" data-options="halign: 'center', align:'center'" style="width: 5%;">性别</th>
                    <th field="phoneNo" data-options="halign: 'center', align:'center'" style="width: 15%;">手机号</th>
                    <th field="email" data-options="halign: 'center', align:'center'" style="width: 15%;">邮箱</th>
                    <th field="deptName" data-options="halign: 'center', align:'center'" style="width: 14%;">部门</th>
                    <th field="createDate" data-options="halign: 'center', align:'center'" style="width: 13%;">创建时间</th>
                    <th field="stateDate" data-options="halign: 'center', align:'center'" style="width: 13%;">修改时间</th>
                </tr>
            </thead>
        </table>
    </div>
	<div id="win" class="easyui-window" title="添加人员" style="width:600px;height:300px;padding: 5px;"   
        data-options="iconCls:'icon-save',modal:true, closed: true">   
	    <form id="staffForm" method="post" style="width: 100%;margin: 0 auto;">
	    		<table class="kv-table" style="width:100%;">
					<tbody>
						<tr>
							<td class="kv-label">姓名：</td>
							<td class="kv-content">
								<input name="staffName" id="staffName" type="text" class="textbox-text" style="width:90%;"  maxlength="50" title="请输入姓名，最多50个字节" />
								<font color="red">*</font>
							</td>
							<td class="kv-label">登录名：</td>
							<td class="kv-content">
								<input name="staffEname" id="staffEname" type="text" class="textbox-text" style="width:90%;" maxlength="50" title="请输入登录名，最多50个字节" />
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class="kv-label">密码：</td>
							<td class="kv-content">
								<input name="password" id="password" type="text" class="textbox-text" style="width:90%;" maxlength="50" title="请输入密码，最多50个字节" />
								<font color="red">*</font>
							</td>
							<td class="kv-label">性别：</td>
							<td class="kv-content">
								<select name="sex" id="sex" title="请选择性别" class="textbox-text" style="width:90%;height: 33px;line-height: 33px;">
		        					<option value="男">男</option>
		        					<option value="女">女</option>
		        				</select><font color="red">&nbsp;&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td class="kv-label">手机号：</td>
							<td class="kv-content">
								<input name="phoneNo" id="phoneNo" type="text" class="textbox-text" maxlength="11" style="width:90%;" title="请输入手机号，最多11个字节" />
								<font color="red">*</font>
							</td>
							<td class="kv-label">邮箱：</td>
							<td class="kv-content">
								<input name="email" id="email" type="text" class="textbox-text" maxlength="50" style="width:90%;" title="请输入邮箱，最多50个字节" />
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td class="kv-label">部门：</td>
							<td class="kv-content">
								<input name="deptName" id="deptName" type="text" class="textbox-text" maxlength="255" style="width:90%;" title="请输入部门，最多255个字节" />
								<font color="red">*</font>
							</td>
							<td class="kv-content" colspan="2"></td>
						</tr>
					</tbody>
				</table>
		    <div style="margin-top: 10px;">
		    	<a href="javascript:;" id="submitBtn" class="easyui-linkbutton" iconCls="icon-ok" style="float: right;margin-left: 10px;" data-options="selected:true">提交</a>
        		<a href="javascript:;" id="resetAddBtn" class="easyui-linkbutton" iconCls="icon-reload"  style="float: right;margin-right: 30px;">重置</a>
		    </div>
		</form>  
	</div>
	
	 <script type="text/javascript" src="../custom/jquery.min.js"></script>
    <script type="text/javascript" src="../custom/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../custom/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
    	$(function(){
    		 $("#dg").datagrid({
    			pagination: true,
    			striped: true,
    			toolbar: '#tb',
				idField: 'id',
				url: '/mdm/staffController/list',
				rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                fitColumns:true,
                striped:true,
                checkOnSelect:true,
                selectOnCheck:true,
                collapsible:true,
                toolbar:'#tb',
                pageSize:10
    		}); 
    		
    		
    		
    		$("#qryBtn").click(function(){
    			$("#dg").datagrid('load', {
    				name: $('input[name=name]').val()
    			});
    		});
    		
    		$('#resetBtn').click(function(){
    			//$("#name").attr("value","");
    			$("#query")[0].reset();
    		});
    		
    		$('#deleteBtn').click(function(){
    			var checkedRows = $('#dg').datagrid('getChecked');
    			var idList = new Array();
    			for(i=0, len = checkedRows.length; i < len; i++){
    				idList.push(checkedRows[i].id);
    			}
    			if(idList.length < 1){
    				$.messager.alert('删除失败', '请在要删除的人员前面打钩', 'error');
    				return;
    			}
    			$.messager.confirm('删除确认', '是否删除这'+idList.length+'条', function(b){
    				if(b){
    					$.post('/mdm/staffController/delete', {ids: idList.join(',')}, function(data){
    						if(data.result == 0){
    							$.messager.alert('删除成功', data.resultDesc, 'info', function(){$('#dg').datagrid('reload');});
    						}else{
    							$.messager.alert('删除失败', data.resultDesc, 'error', function(){$('#dg').datagrid('reload');});
    						}
    					});
    					
    				}
    			});
    		});
    		
    		$('#addBtn').click(function(){
    			$('#win').window('open');
    		});
			
			$('#resetAddBtn').click(function(){
				$('#staffForm').form('clear');
			});
			
			$("#submitBtn").click(function(){
				if ($("#staffName").val() == "") {
	                alert("姓名不能为空！");
	                $("#staffName").focus();
	                return false;
	            }
				if ($("#staffEname").val() == "") {
	                alert("登录名不能为空！");
	                $("#staffEname").focus();
	                return false;
	            }
				if ($("#password").val() == "") {
	                alert("密码不能为空！");
	                $("#password").focus();
	                return false;
	            }
				if (null==$("#sex").val()||$("#sex").val() == "") {
	                alert("性别不能为空！");
	                $("#sex").focus();
	                return false;
	            }
	            if ($("#phoneNo").val() == "") {
	                alert("手机号不能为空！");
	                $("#phoneNo").focus();
	                return false;
	            }
	            if ($("#email").val() == "") {
	                alert("邮箱不能为空！");
	                $("#email").focus();
	                return false;
	            }
	            if ($("#deptName").val() == "") {
	                alert("部门不能为空！");
	                $("#deptName").focus();
	                return false;
	            }
	            
	            var staff = new Object();
	            staff.id = "";
	            staff.staffName = $("#staffName").val();
	            staff.staffEname = $("#staffEname").val();
	            staff.password = $("#password").val();
	            staff.sex = $("#sex").val();
	            staff.phoneNo = $("#phoneNo").val();
	            staff.email = $("#email").val();
	            staff.deptName = $("#deptName").val();
	            staff.isAdmin = "0";
	            staff.staffState = "1";
	            staff.createDate = "";
	            staff.stateDate = "";
	            //alert(JSON.stringify(staff));
	            $.ajax({
	                type: "POST",
	                url: "/mdm/staffController/add",
	               	dataType:"json",
	               	async:false,
	                data:"staff="+ JSON.stringify(staff)+"",
	                success: function (data) {
	                	if (data.result == "0") {
	                		$.messager.confirm('添加人员成功', '点击确定刷新页面', function(){
	                			$('#staffForm').form('clear');
	                			$('#dg').datagrid('reload');
	                			$('#win').window('close');
	            			});
	                    }
	                    else {
	                    	$.messager.confirm('添加人员失败', '请查看输入参数是否正确', function(){
	                    		$('#staffForm').form('clear');
	            			});
	                    }
	                }

	            });	
			});
    	});
    </script>
</body> 
</html>
