package com.github.jptx1234.mdm.controller;


import java.util.ArrayList;
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
import com.github.jptx1234.mdm.model.StuffPackDecompose;
import com.github.jptx1234.mdm.service.StuffPackDecomposeService;
import com.github.jptx1234.mdm.util.FileUploadUtils;

/**
 * 物品包类别
 *
 */
@RequestMapping("/stuffPackDecompose")
@RestController
public class StuffPackDecomposeController {
	private static final Logger logger = Logger.getLogger(StuffPackDecomposeController.class);

	@Autowired
	private StuffPackDecomposeService stuffPackDecomposeService;
	
	@RequestMapping("/list")
	public JSON list(@RequestParam(value="kw", required=false, defaultValue="") String kw, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize) {
		logger.info("查物品包分解实例列表，查询条件：kw="+kw+"，页号"+page+"，页大小"+pageSize);
		int total = 0;
		List<StuffPackDecompose> rows = new ArrayList<>();
		JSONObject resultObject = new JSONObject();
		try {
			total = stuffPackDecomposeService.countBlur(kw);
			rows = stuffPackDecomposeService.listBlur(kw, page, pageSize);
			resultObject.put("status", 200);
			resultObject.put("msg", "查询成功");
		}catch (Exception e) {
			logger.error("查物品包列表出错", e);
			resultObject.put("status", 500);
			resultObject.put("msg", "查询出错："+e.getLocalizedMessage());
		}
		resultObject.put("total", total);
		resultObject.put("rows", rows);
		
		logger.info("查询结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/delete")
	public JSON delete(@RequestParam(value="id") List<Integer> idList) {
		logger.info("正在删除物品包分解实例"+idList);
		JSONObject resultObject = new JSONObject();
		try {
			int count = stuffPackDecomposeService.delete(idList);
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
	public JSON add(@RequestParam("packId") Integer packId,  @RequestParam("decomposeName") String decomposeName, @RequestParam("decomposeDesc") String decomposeDesc, @RequestParam(value="decomposeImg", required=false) MultipartFile file) {
		String decomposeImg = FileUploadUtils.uploadFile(file);
		StuffPackDecompose stuffPackDecompose = new StuffPackDecompose();
		
		stuffPackDecompose.setPackId(packId);
		stuffPackDecompose.setDecomposeName(decomposeName);
		stuffPackDecompose.setDecomposeDesc(decomposeDesc);
		stuffPackDecompose.setDecomposeImg(decomposeImg);
		
		logger.info("物品包分解实例添加接口正在添加："+stuffPackDecompose);
		
		JSONObject resultObject = new JSONObject();
		try {
			stuffPackDecomposeService.add(stuffPackDecompose);
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
