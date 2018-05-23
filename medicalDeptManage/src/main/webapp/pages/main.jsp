<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.github.jptx1234.mdm.model.Staff" %>
<%	
	if(null==request.getSession().getAttribute("staff")){
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}
	Staff staff = (Staff)request.getSession().getAttribute("staff");
	String staffName = staff.getStaffName();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>科室信息管理系统</title> 
<link href="css/base.css" rel="stylesheet">
<link href="css/platform.css" rel="stylesheet">
<link rel="stylesheet" href="../custom/uimaker/easyui.css">
</head> 
<body>
    <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img src="images/main/main_logo.png" alt="logo">
            </div>
            
            <!-- <div class="pf-nav-wrap">
              <div class="pf-nav-ww">
                <ul class="pf-nav">
                  <li class="pf-nav-item home current" data-menu="sys-manage">
                      <a href="javascript:;">
                          <span class="iconfont">&#xe63f;</span>
                          <span class="pf-nav-title">系统管理</span>
                      </a>
                  </li>
                  <li class="pf-nav-item project" data-menu="org-manage">
                      <a href="javascript:;">
                          <span class="iconfont">&#xe60d;</span>
                          <span class="pf-nav-title">物品包管理</span>
                      </a>
                  </li>
                  <li class="pf-nav-item static" data-menu="main-data">
                      <a href="javascript:;">
                          <span class="iconfont">&#xe61e;</span>
                          <span class="pf-nav-title">文档管理</span>
                      </a>
                  </li>
                </ul>
              </div>
              

              <a href="javascript:;" class="pf-nav-prev disabled iconfont">&#xe606;</a>
              <a href="javascript:;" class="pf-nav-next iconfont">&#xe607;</a>
            </div> -->
            


            <div class="pf-user">
                <div class="pf-user-photo">
                    <img src="images/main/user.png" alt="">
                </div>
                <h4 class="pf-user-name ellipsis"><%=staffName %></h4>
                <i class="iconfont xiala">&#xe607;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <!-- <li>
                            <a href="javascript:;">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                        <li class="pf-modify-pwd">
                            <a href="http://www.uimaker.com">
                                <i class="iconfont">&#xe634;</i>
                                <span class="pf-opt-name">修改密码</span>
                            </a>
                        </li> -->
                        <li class="pf-logout">
                            <a href="javascript:void(0);" onclick="loginOut();">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name" >退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>

        <div id="pf-bd">
            <div id="pf-sider">
                <h2 class="pf-model-name">
                    <span class="iconfont">&#xe64a;</span>
                    <span class="pf-name">功能菜单</span>
                    <span class="toggle-icon"></span>
                </h2>

                <ul class="sider-nav">
                     <li class="current">
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe620;</span>
                            <span class="sider-nav-title">物品包管理</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                         <ul class="sider-nav-s">
                           <li class=""><a href="javascript:void(0);" onclick="openPageAtTab('物品包类别维护','stuffPackTypeList.html');">物品包类别维护</a></li>
                           <li class=""><a href="javascript:void(0);" onclick="openPageAtTab('物品包实例维护','stuffPackList.html');">物品包实例维护</a></li>
                           <li class=""><a href="javascript:;" onclick="openPageAtTab('物品包分解实例维护','stuffPackDecompose.html');">物品包分解实例维护</a></li> 
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe611;</span>
                            <span class="sider-nav-title">文档管理</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
                           <li class=""><a href="javascript:;" onclick="openPageAtTab('文档类别维护','docType.html');">文档类别维护</a></li> 
                           <li class=""><a href="javascript:;" onclick="openPageAtTab('文档上传和维护','docInstance.html');">文档上传和维护</a></li> 
                        </ul>
                     </li>
                     <li>
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe633;</span>
                            <span class="sider-nav-title" href="javascript:void(0);" onclick="openPageAtTab('人员管理','staffManage.jsp');">人员管理</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                     </li>
                 </ul> 
            </div>

            <div id="pf-page">
                <div class="easyui-tabs1" style="width:100%;height:100%;">
                    <div id="main_iframe" title="首页" style="padding:10px 5px 5px 10px;">
                      <iframe class="page-iframe" src="workbench.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                    </div>
                </div>
            </div>
        </div>

        <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>信息管理系统&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>CopyRight&nbsp;2016&nbsp;&nbsp;csy&nbsp;版权所有</span>
              <i class="iconfont" >&#xe6ff;</i>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="../custom/jquery.min.js"></script>
    <script type="text/javascript" src="../custom/jquery.easyui.min.js"></script>
    <!-- <script type="text/javascript" src="js/menu.js"></script> -->
    <script type="text/javascript" src="js/main.js"></script>
    <!--[if IE 7]>
      <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
        
      </script>
    <![endif]-->  

    
    <script type="text/javascript">
    $('.easyui-tabs1').tabs({
      tabHeight: 44,
      onSelect:function(title,index){
        var currentTab = $('.easyui-tabs1').tabs("getSelected");
        if(currentTab.find("iframe") && currentTab.find("iframe").size()){
            currentTab.find("iframe").attr("src",currentTab.find("iframe").attr("src"));
        }
      }
    })
    $(window).resize(function(){
          $('.tabs-panels').height($("#pf-page").height()-46);
          $('.panel-body').height($("#pf-page").height()-76)
    }).resize();

    var page = 0,
        pages = ($('.pf-nav').height() / 70) - 1;

    if(pages === 0){
      $('.pf-nav-prev,.pf-nav-next').hide();
    }
    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){


      if($(this).hasClass('disabled')) return;
      if($(this).hasClass('pf-nav-next')){
        page++;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == pages){
          $(this).addClass('disabled');
          $('.pf-nav-prev').removeClass('disabled');
        }else{
          $('.pf-nav-prev').removeClass('disabled');
        }
        
      }else{
        page--;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == 0){
          $(this).addClass('disabled');
          $('.pf-nav-next').removeClass('disabled');
        }else{
          $('.pf-nav-next').removeClass('disabled');
        }
        
      }
    })

    // setTimeout(function(){
    //    $('.tabs-panels').height($("#pf-page").height()-46);
    //    $('.panel-body').height($("#pf-page").height()-76)
    // }, 200)

    function openPageAtTab(title,url){
      /*alert(title);
      alert(url);
      var innerHtml = "<div title=\""+title+"\" style=\"padding:10px 5px 5px 10px;\" data-options=\"closable:true\"><iframe class=\"page-iframe\" src=\""+url+"\" frameborder=\"no\"   border=\"no\" height=\"100%\" width=\"100%\" scrolling=\"auto\"></iframe></div>";
      alert(innerHtml);
      alert($('.easyui-tabs1').html());
      $('.easyui-tabs1').append(innerHtml);*/
      $("#main_iframe").attr("title",title);
      $(".page-iframe").attr("src",url);
    }
	
    
    function loginOut(){
    	window.location.href = "/mdm/pages/loginOut.jsp";
    }

    </script>
</body>
</html>