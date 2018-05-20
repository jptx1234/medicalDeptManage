package com.github.jptx1234.mdm.controller;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.jptx1234.mdm.model.StuffPack;
import com.github.jptx1234.mdm.service.StuffPackService;
import com.github.jptx1234.mdm.util.FileUploadUtils;

/**
 * 物品包类别
 *
 */
@RequestMapping("/stuffPack")
@RestController
public class StuffPackController {
	private static final Logger logger = Logger.getLogger(StuffPackController.class);

	@Autowired
	private StuffPackService stuffPackService;
	
	@RequestMapping("/list")
	public JSON list(@RequestParam(value="kw", required=false, defaultValue="") String kw, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize) {
		logger.info("查物品包列表，查询条件：kw="+kw+"，页号"+page+"，页大小"+pageSize);
		int total = 0;
		List<StuffPack> rows = null;
		try {
			total = stuffPackService.countBlur(kw);
			rows = stuffPackService.listBlur(kw, page, pageSize);
		}catch (Exception e) {
			logger.error("查物品包列表出错", e);
		}
		
		JSONObject resultObject = new JSONObject();
		resultObject.put("total", total);
		resultObject.put("rows", rows);
		logger.info("查询结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/delete")
	public JSON delete(@RequestParam(value="id") List<Integer> idList) {
		logger.info("正在删除包"+idList);
		JSONObject resultObject = new JSONObject();
		try {
			int count = stuffPackService.delete(idList);
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
		logger.info("物品包删除结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/add")
	public JSON add(@RequestParam("packTypeId") Integer packTypeId,  @RequestParam("packName") String packName, @RequestParam("packDesc") String packDesc, @RequestParam(value="packImg", required=false) MultipartFile file) {
		String packImg = FileUploadUtils.uploadFile(file);
		StuffPack stuffPack = new StuffPack();
		
		stuffPack.setPackTypeId(packTypeId);
		stuffPack.setPackName(packName);
		stuffPack.setPackDesc(packDesc);
		stuffPack.setPackImg(packImg);
		
		logger.info("物品包类别添加接口正在添加："+stuffPack);
		
		JSONObject resultObject = new JSONObject();
		try {
			stuffPackService.add(stuffPack);
			resultObject.put("status", 200);
			resultObject.put("msg", "添加成功");
		}catch (Exception e) {
			logger.error("添加物品包类别出错", e);
			resultObject.put("status", 500);
			resultObject.put("msg", "添加出错：" + e.getLocalizedMessage());
		}
		
		return resultObject;
	}
	

}
