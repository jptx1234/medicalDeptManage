<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	if(null!=request.getSession().getAttribute("staff")){
		request.getSession().removeAttribute("staff");
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}else{
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}
	
%>