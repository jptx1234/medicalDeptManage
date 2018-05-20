package com.github.jptx1234.mdm.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.jptx1234.mdm.util.FileUploadUtils;

@RestController
public class FileController {

	@RequestMapping("/file")
	public ResponseEntity<byte[]> download(@RequestParam("path") String path, Model model) throws Exception {
		File file = FileUploadUtils.downloadFile(path);
		byte[] fileBytes = file != null ? FileUtils.readFileToByteArray(file) : new byte[0];
		return new ResponseEntity<byte[]>(fileBytes, HttpStatus.CREATED);
	}

}
