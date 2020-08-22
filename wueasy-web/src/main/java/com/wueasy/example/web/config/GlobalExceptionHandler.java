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
package com.wueasy.example.web.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

import com.wueasy.example.core.exception.InvokeException;
import com.wueasy.example.core.util.JsonUtil;
import com.wueasy.example.core.vo.ResultVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理
 * @author: fallsea
 * @version 1.0
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MultipartException.class)
    public String handleError1(HttpServletResponse response,MultipartException e) {
		ResultVo<Void> result = new ResultVo<>(-1,"文件大小超出限制！");
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return JsonUtil.toJsonString(result);
    }
	
	@ExceptionHandler(InvokeException.class)
    public String handleInvokeException(HttpServletResponse response,InvokeException invokeException) {
		ResultVo<Void> result = new ResultVo<>();
		result.setErrorNo(invokeException.getErrorCode());
		result.setErrorInfo(invokeException.getMessage());
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return JsonUtil.toJsonString(result);
    }
	
	@ExceptionHandler(Exception.class)
    public String handleException(HttpServletResponse response,Exception e) {
		log.error("",e);
		ResultVo<Void> result = new ResultVo<>(-1,"系统出现未知异常！");
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return JsonUtil.toJsonString(result);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String code = error.getDefaultMessage();
        return JsonUtil.toJsonString(new ResultVo<>(-1,code));
    }
}
