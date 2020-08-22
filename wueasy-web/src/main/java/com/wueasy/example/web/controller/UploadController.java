/*
 * Copyright (C) 2017-2020 wueasy.com , All Rights Reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */	
package com.wueasy.example.web.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wueasy.example.core.exception.InvokeException;
import com.wueasy.example.core.vo.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 上传
 * @author: fallsea
 * @version 1.0
 */
@Controller
@Api(tags = "文件上传")
@RequestMapping("/upload")
public class UploadController {
	
	@Value("${upload.fileRootPath:''}")
	private String fileRootPath;
	@Value("${upload.httpAccessPath:''}")
	private String httpAccessPath;
    
	@ApiOperation("上传附件")
	@RequestMapping(value={"/file"},method = RequestMethod.POST)
	@ResponseBody
	public ResultVo<String> uploadFile(@RequestParam("file") MultipartFile file){
		if (file.isEmpty()) {
            throw new InvokeException(-1, "文件不能为空!");
        }
        if (file.getSize() > 20 * 1024 * 1024) {
            throw new InvokeException(-2, "文件大小不能超过20M!");
        }
        
        String filePath =  "/"+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) +"/" + UUID.randomUUID().toString() +"." + FilenameUtils.getExtension(file.getOriginalFilename());
        try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(FilenameUtils.normalize(fileRootPath+filePath)));
		} catch (IOException e) {
			throw new InvokeException(-2, "文件上传失败!");
		}
		return new ResultVo<>(httpAccessPath+filePath);
	}
	

}