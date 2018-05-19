package com.github.jptx1234.mdm.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.jptx1234.mdm.model.StuffPackType;
import com.github.jptx1234.mdm.service.StuffPackTypeService;

/**
 * 物品包类别
 *
 */
@RequestMapping("/stuffPackType")
@RestController
public class StuffPackTypeController {
	private static final Logger logger = Logger.getLogger(StuffPackTypeController.class);

	@Autowired
	private StuffPackTypeService stuffPackTypeService;
	
	@RequestMapping("/list")
	public JSON list(@RequestParam(value="name", required=false) String name) {
		StuffPackType example = new StuffPackType();
		example.setPackTypeName(name);
		int total = 0;
		List<StuffPackType> rows = null;
		try {
			total = stuffPackTypeService.count(example);
			rows = stuffPackTypeService.list(example, 1, 10);
		}catch (Exception e) {
			logger.error("查物品包分类列表出错", e);
		}
		
		JSONObject resultObject = new JSONObject();
		resultObject.put("total", total);
		resultObject.put("rowd", rows);
		
		return resultObject;
	}
	
	
	

}
