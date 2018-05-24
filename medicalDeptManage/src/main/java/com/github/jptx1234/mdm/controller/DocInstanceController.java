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
import com.github.jptx1234.mdm.model.DocInstance;
import com.github.jptx1234.mdm.service.DocInstanceService;
import com.github.jptx1234.mdm.util.FileUploadUtils;

/**
 * 物品包类别
 *
 */
@RequestMapping("/docInstance")
@RestController
public class DocInstanceController {
	private static final Logger logger = Logger.getLogger(DocInstanceController.class);

	@Autowired
	private DocInstanceService docInstanceService;
	
	@RequestMapping("/list")
	public JSON list(@RequestParam(value="kw", required=false, defaultValue="") String kw, @RequestParam(value="page", required=false, defaultValue="1") Integer page, @RequestParam(value="rows", required=false, defaultValue="100") Integer pageSize, @RequestParam(value="doc_type_id", required=false) Integer doc_type_id) {
		logger.info("查文档实例列表，查询条件：kw="+kw+"，页号"+page+"，页大小"+pageSize);
		int total = 0;
		List<DocInstance> rows = new ArrayList<>();
		JSONObject resultObject = new JSONObject();
		try {
			total = docInstanceService.countBlur(kw, doc_type_id);
			rows = docInstanceService.listBlur(kw, page, pageSize, doc_type_id);
			resultObject.put("status", 200);
			resultObject.put("msg", "查询成功");
		}catch (Exception e) {
			logger.error("查文档实例出错", e);
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
		logger.info("正在删除文档实例"+idList);
		JSONObject resultObject = new JSONObject();
		try {
			int count = docInstanceService.delete(idList);
			resultObject.put("status", 200);
			resultObject.put("msg", "成功删除"+count+"条");
		}catch (Exception e) {
			logger.error("删除文档实例出错", e);
			resultObject.put("status", 500);
			resultObject.put("msg", "删除失败："+
					(StringUtils.isBlank(e.getLocalizedMessage()) ? 
							e.getClass().getSimpleName() 
							: e.getLocalizedMessage()));
		}
		logger.info("文档实例删除结果："+resultObject);
		
		return resultObject;
	}
	
	@RequestMapping("/add")
	public JSON add(@RequestParam("doc_type_id") Integer doc_type_id,  @RequestParam("doc_name") String doc_name, @RequestParam("doc_desc") String doc_desc, @RequestParam("doc_author") String doc_author, @RequestParam("is_html") String is_html, @RequestParam(value="doc_path", required=false) MultipartFile file, @RequestParam(value="doc_html", required=false) String doc_html) {
		
		DocInstance docInstance = new DocInstance();
		docInstance.setDoc_type_id(doc_type_id);
		docInstance.setDoc_name(doc_name);
		docInstance.setDoc_desc(doc_desc);
		docInstance.setDoc_author(doc_author);
		docInstance.setIs_html(is_html);
		if("0".equals(is_html)) {
			String docInstancePath = FileUploadUtils.uploadFile(file);
			docInstance.setDoc_path(docInstancePath);
		}else {
			docInstance.setDoc_html(doc_html);
		}
		
		logger.info("文档实例添加接口正在添加："+docInstance);
		
		JSONObject resultObject = new JSONObject();
		try {
			docInstanceService.add(docInstance);
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
