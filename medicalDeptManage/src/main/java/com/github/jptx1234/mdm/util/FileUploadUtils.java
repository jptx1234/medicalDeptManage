package com.github.jptx1234.mdm.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 *
 */
public class FileUploadUtils {
	
	private static final Logger logger = Logger.getLogger(FileUploadUtils.class);
	private static final DateFormat yyyyMMddFormat = new SimpleDateFormat("yyyyMMdd");
	private static String fileSavePath = null;
	
	public static void setFileSavePath(String path) {
		File fileSavePathFile = new File(path);
		if(!fileSavePathFile.exists()) {
			fileSavePathFile.mkdirs();
		}else if(fileSavePathFile.isFile()) {
			logger.error("路径"+path+"是个文件，不是目录，文件上传会失败！");
			throw new RuntimeException("路径"+path+"是个文件，不是目录，请删除此文件，否则文件上传会失败！为避免上传失败，已主动关闭服务器。");
		}
		
		fileSavePath = fileSavePathFile.getAbsolutePath();
	}

	/**
	 * 上传文件，直接把SpringMVC的MultipartFile传过来即可
	 * @param file SpringMVC的MultipartFile
	 * @return 相对路径，可直接存入数据库
	 */
	public static String uploadFile(MultipartFile file) {
		if(file == null || file.isEmpty()) {
			return StringUtils.EMPTY;
		}
		
		String todayDirString = yyyyMMddFormat.format(new Date());
		File todayDir = new File(fileSavePath + File.separator + todayDirString);
		if(!todayDir.exists()) {
			todayDir.mkdirs();
		}
		String filename = file.getOriginalFilename();
		String extensionName = FilenameUtils.getExtension(filename);
		File newFile = new File(todayDir, UUID.randomUUID().toString() + "." + extensionName);
		logger.info("上传文件到"+newFile.getAbsolutePath());
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			logger.error("文件上传失败", e);
			return StringUtils.EMPTY;
		}
		
		return todayDirString + File.separator + newFile.getName();
	}
	
	/**
	 * 下载文件，传入相对路径返回文件
	 * @param path 相对路径，从数据库里取出来的
	 * @return 文件，如果没找到，就返回null
	 */
	public static File downloadFile(String path) {
		if(StringUtils.isBlank(path)) {
			return null;
		}
		
		File realFile = new File(fileSavePath + File.separator + path);
		
		return realFile.exists() ? realFile : null;
	}
	
}
