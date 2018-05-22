<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>科室信息管理系统</title> 
    <link href="pages/css/base.css" rel="stylesheet">
    <link href="pages/css/login/login.css" rel="stylesheet">
    
    <script language="javascript" src="custom/jquery.min.js" ></script>

</head> 
<body>
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
			<span class="sys-name">科室信息管理系统</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<div class="alert alert-error" style="display:none;">
			              <i class="iconfont">&#xe62e;</i>
			              <span>请输入用户名</span>
			            </div>
						<form id="logonForm" name="logonForm">
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input name="staffEname" id="staffEname" type="text" placeholder="账号/邮箱">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input name="password" id="password" type="password" placeholder="请输入密码">
							</div>
							<div class="lg-check clearfix" style="display:none;">
								<div class="input-item">
									<i class="iconfont">&#xe633;</i>
									<input type="text" placeholder="验证码">
								</div>
								<span class="check-code">XD34F</span>
							</div>
							<div class="tips clearfix" style="display:none;">
								<label><input type="checkbox" checked="checked">记住用户名</label>
								<a href="javascript:;" class="register">立即注册</a>
								<a href="javascript:;" class="forget-pwd">忘记密码？</a>
							</div>
							<div class="enter" style="width:100%;">
								<a href="javascript:;" style="float:right;width:82%;margin-right:30px;" class="supplier" onClick="userLogon();">登录</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function userLogon(){
			
			if ($("#staffEname").val() == "") {
                //alert("用户名不能为空！");
                $("#staffEname").focus();
                return false;
            }
            if ($("#password").val() == "") {
                //alert("密码不能为空！");
                $("#password").focus();
                return false;
            }
            
            var staff = new Object();
            staff.id = "";
            staff.staffName = "";
            staff.staffEname = $("#staffEname").val();
            staff.password = $("#password").val();
            staff.sex = "";
            staff.phoneNo = "";
            staff.email = "";
            staff.deptName = "";
            staff.isAdmin = "";
            staff.staffState = "";
            staff.createDate = "";
            staff.stateDate = "";
            alert(JSON.stringify(staff));
            $.ajax({
                type: "POST",
                url: "/mdm/staffController/logon",
               	dataType:"json",
               	async:false,
                data:"staff="+ JSON.stringify(staff),
                success: function (data) {
                	if (data.result == "0") {
                        location.href = "pages/main.jsp";
                        return true;
                    }
                    else {
                        alert(data.resultDesc);
                        $("#staffEname").val("");
                        $("#password").val("");
                        $("#staffEname").focus();
                        return false;
                    }
                }

            });			
		}
	</script>
</body> 
</html>