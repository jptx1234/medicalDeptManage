package com.github.jptx1234.mdm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.jptx1234.mdm.model.Staff;
import com.github.jptx1234.mdm.service.StaffService;
import com.github.jptx1234.mdm.util.MD5;

@Controller
@RequestMapping(value="/staffController")
public class StaffController {
	
	private Logger logger = Logger.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	
	
	@RequestMapping(value="/logon")
	@ResponseBody
	public String logon(@RequestParam(name="staff",required=true) String staffJson, HttpServletRequest request) {
		
		
		String returnJson = "";
		//AjaxResult
		
		Staff staff = new Staff();
		staff = JSON.parseObject(staffJson, Staff.class);
		logger.info("登录名称："+staff.getStaffEname()+"登录密码明文："+staff.getPassword());
		String staffEname = staff.getStaffEname();
		String password = staff.getPassword();//前台传来的明文
		String passwordMd5 = MD5.MD5Encode(password);
		
		//从数据库里面根据staffEname查询出密文；
		Staff staffDb = new Staff();
		staffDb = staffService.getPwdByEName(staffEname);
		String passwordDb = staffDb.getPassword();
		logger.info("数据库里面查询出来的密码密文："+passwordDb);
		
		Map returnMap = new HashMap();
		
		if(passwordMd5.equals(passwordDb)) {//密码校验一致，登录成功，将Map去除掉MD5密文，转成json返回前台
			request.getSession().setAttribute("staff", staffDb);
			returnMap.put("staff", staffDb);
			returnMap.put("result", "0");
			returnMap.put("resultDesc", "登录成功");
			returnJson = JSON.toJSONString(returnMap);
		}else {
			returnMap.put("result", "1");
			returnMap.put("resultDesc", "密码输入错误，请检查后再重新输入！");
			returnJson = JSON.toJSONString(returnMap);
		}
		
		return returnJson;
	}
	
}
