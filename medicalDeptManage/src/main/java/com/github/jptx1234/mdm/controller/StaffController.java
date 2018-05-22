package com.github.jptx1234.mdm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.jptx1234.mdm.model.Staff;
import com.github.jptx1234.mdm.model.StaffExample;
import com.github.jptx1234.mdm.model.StaffExample.Criteria;
import com.github.jptx1234.mdm.service.StaffService;
import com.github.jptx1234.mdm.util.MD5;

@Controller
@RequestMapping(value="/staffController")
public class StaffController {
	
	private Logger logger = Logger.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	
	
	@RequestMapping(value="/logon",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String logon(@RequestParam(name="staff",required=true) String staffJson, HttpServletRequest request) {
		String returnJson = "";
		//AjaxResult
		Map returnMap = new HashMap();
		Staff staff = new Staff();
		String staffEname = "";
		String password = "";
		try {
			staff = JSON.parseObject(staffJson, Staff.class);
			logger.info("登录名称："+staff.getStaffEname()+"登录密码明文："+staff.getPassword());
			staffEname = staff.getStaffEname();
			password = staff.getPassword();//前台传来的明文
			if(null==staffEname||null==password) {
				throw new Exception("入参不正常！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("入参校验不通过！", e);
			returnMap.put("result", "1");
			returnMap.put("resultDesc", "密码输入错误，请检查后再重新输入！");
			returnJson = JSON.toJSONString(returnMap);
			return returnJson;
		}
		
		String passwordMd5 = MD5.MD5Encode(password);
		
		//从数据库里面根据staffEname查询出密文；
		Staff staffDb = new Staff();
		staffDb = staffService.getPwdByEName(staffEname);
		String passwordDb = staffDb.getPassword();
		logger.info("数据库里面查询出来的密码密文："+passwordDb);
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
	
	@RequestMapping("/list")
	@ResponseBody
	public JSON queryStaffs(@RequestParam(value="name", required=false) String name, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize) {
		logger.info("查人员列表，查询条件：name="+name+"，页号"+page+"，页大小"+pageSize);
		int start = pageSize * (page - 1);
		StaffExample example = new StaffExample();
		if(!"".equals(name)&&null!=name) {
			Criteria criteria = example.createCriteria();
			criteria.andStaffNameLike("%"+name+"%");
		}
		
		example.setStartRow(start);
		example.setPageSize(pageSize);
		
		int total = 0;
		List<Staff> rows = null;
		try {
			total = staffService.countByExample(example);
			rows = staffService.selectByExample(example);
		}catch (Exception e) {
			logger.error("查人员列表出错", e);
		}
		
		JSONObject resultObject = new JSONObject();
		resultObject.put("total", total);
		resultObject.put("rows", rows);
		logger.info("查询结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JSON deleteStaffs(@RequestParam(value="ids",required=true) String ids) {
		logger.info("入参："+ids);
		JSONObject resultObject = new JSONObject();
		String[] idArray = ids.split(",");
		if(null==idArray||idArray.length==0) {
			resultObject.put("result", "1");
			resultObject.put("resultDesc", "传入ID为空,删除失败");
		}else {
			try {
				for(int i=0;i<idArray.length;i++) {
					String idStr = idArray[i];
					Integer id = Integer.parseInt(idStr);
					staffService.deleteStaff(id);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				logger.error("删除失败", e);
				resultObject.put("result", "1");
				resultObject.put("resultDesc", "删除失败");
			}
			resultObject.put("result", "0");
			resultObject.put("resultDesc", "删除成功");
		}
		return resultObject;
	}
	
	
	@RequestMapping(value="/add")
	@ResponseBody
	public String addStaff(@RequestParam(name="staff",required=true) String staffJson) {
		String returnJson = "";
		Map returnMap = new HashMap();
		Staff staff = new Staff();
		staff = JSON.parseObject(staffJson, Staff.class);
		
		
		String password = staff.getPassword();
		String passwordMD5 = MD5.MD5Encode(password);
		staff.setPassword(passwordMD5);
		//java.util.Date now = new java.util.Date();
		
		//staff.setCreateDate(new Date(now.getTime()));
		//staff.setStateDate(new Date(now.getTime()));
		/*staff.setCreateDate(new Date());
		staff.setStateDate(new Date());*/
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		staff.setCreateDate(sdf.format(date));
		staff.setStateDate(sdf.format(date));
		
		try {
			int i = staffService.insertStaff(staff);
			if(i==1) {
				returnMap.put("result", "0");
				returnMap.put("resultDesc", "登录成功");
			}else {
				throw new Exception("插入有误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("添加人员失败", e);
			returnMap.put("result", "1");
			returnMap.put("resultDesc", "添加人员失败");
		}
		returnJson = JSON.toJSONString(returnMap);
		return returnJson;
	}
	
}
