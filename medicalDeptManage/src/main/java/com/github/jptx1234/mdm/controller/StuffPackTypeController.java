package com.github.jptx1234.mdm.controller;


import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	public JSON list(@RequestParam(value="name", required=false) String name, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize) {
		logger.info("查物品包分类列表，查询条件：name="+name+"，页号"+page+"，页大小"+pageSize);
		StuffPackType example = new StuffPackType();
		example.setPackTypeName(name);
		int total = 0;
		List<StuffPackType> rows = null;
		try {
			total = stuffPackTypeService.count(example);
			rows = stuffPackTypeService.list(example, page, pageSize);
		}catch (Exception e) {
			logger.error("查物品包分类列表出错", e);
		}
		
		JSONObject resultObject = new JSONObject();
		resultObject.put("total", total);
		resultObject.put("rows", rows);
		logger.info("查询结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/delete")
	public JSON delete(@RequestParam(value="id") List<Integer> idList) {
		JSONObject resultObject = new JSONObject();
		try {
			int count = stuffPackTypeService.delete(idList);
			resultObject.put("status", 200);
			resultObject.put("msg", "成功删除"+count+"条");
		}catch (Exception e) {
			logger.error("删除物品包分类列表出错", e);
			resultObject.put("status", 500);
			resultObject.put("msg", "删除失败："+
					(StringUtils.isBlank(e.getLocalizedMessage()) ? 
							e.getClass().getSimpleName() 
							: e.getLocalizedMessage()));
		}
		
		return resultObject;
	}
	
	

}
