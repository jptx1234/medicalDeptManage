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
import com.github.jptx1234.mdm.model.DocType;
import com.github.jptx1234.mdm.service.DocTypeService;
import com.github.jptx1234.mdm.util.FileUploadUtils;

/**
 * 物品包类别
 *
 */
@RequestMapping("/docType")
@RestController
public class DocTypeController {
	private static final Logger logger = Logger.getLogger(DocTypeController.class);

	@Autowired
	private DocTypeService docTypeService;
	
	@RequestMapping("/list")
	public JSON list(@RequestParam(value="kw", required=false, defaultValue="") String kw, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize) {
		logger.info("查文档类别列表，查询条件：kw="+kw+"，页号"+page+"，页大小"+pageSize);
		int total = 0;
		List<DocType> rows = new ArrayList<>();
		JSONObject resultObject = new JSONObject();
		try {
			total = docTypeService.countBlur(kw);
			rows = docTypeService.listBlur(kw, page, pageSize);
			resultObject.put("status", 200);
			resultObject.put("msg", "查询成功");
		}catch (Exception e) {
			logger.error("查文档类别出错", e);
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
		logger.info("正在删除文档类别"+idList);
		JSONObject resultObject = new JSONObject();
		try {
			int count = docTypeService.delete(idList);
			resultObject.put("status", 200);
			resultObject.put("msg", "成功删除"+count+"条");
		}catch (Exception e) {
			logger.error("删除文档类别出错", e);
			resultObject.put("status", 500);
			resultObject.put("msg", "删除失败："+
					(StringUtils.isBlank(e.getLocalizedMessage()) ? 
							e.getClass().getSimpleName() 
							: e.getLocalizedMessage()));
		}
		logger.info("文档类别删除结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/add")
	public JSON add(@RequestParam("doc_type_name") String doc_type_name,  @RequestParam("doc_type_desc") String doc_type_desc, @RequestParam(value="doc_type_img", required=false) MultipartFile file) {
		String docTypeImg = FileUploadUtils.uploadFile(file);
		DocType docType = new DocType();
		
		docType.setDoc_type_name(doc_type_name);
		docType.setDoc_type_desc(doc_type_desc);
		docType.setDoc_type_img(docTypeImg);
		
		logger.info("文档类别添加接口正在添加："+docType);
		
		JSONObject resultObject = new JSONObject();
		try {
			docTypeService.add(docType);
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
