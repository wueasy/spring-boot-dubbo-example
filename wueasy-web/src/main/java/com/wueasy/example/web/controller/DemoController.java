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

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wueasy.example.core.vo.PageVo;
import com.wueasy.example.core.vo.ResultVo;
import com.wueasy.example.dto.DemoAddDto;
import com.wueasy.example.dto.DemoEditDto;
import com.wueasy.example.dto.DemoIdDto;
import com.wueasy.example.dto.DemoQueryPageDto;
import com.wueasy.example.service.DemoService;
import com.wueasy.example.vo.DemoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author: fallsea
 * @version 1.0
 */
@Controller
@Api(tags = "demo测试")
@RequestMapping("/demo")
public class DemoController {
	
	@DubboReference(version = "1.0.0")
	private DemoService demoService;
    
	@ApiOperation("查询分页列表")
	@RequestMapping(value={"/queryPage"},method = RequestMethod.POST)
	@ResponseBody
	public ResultVo<PageVo<DemoVo>> queryPage(@RequestBody @Valid DemoQueryPageDto demoQueryPageDto){
		return new ResultVo<>(demoService.queryPage(demoQueryPageDto));
	}
	
	@ApiOperation("新增")
    @RequestMapping(value={"/add"},method = RequestMethod.POST)
    @ResponseBody
    public ResultVo<Void> add(@RequestBody @Valid DemoAddDto demoAddDto){
    	demoService.add(demoAddDto);
    	return new ResultVo<Void>();
    }
	
	@ApiOperation("查询单个记录")
	@RequestMapping(value={"/select"},method = RequestMethod.POST)
	@ResponseBody
	public ResultVo<DemoVo> select(@RequestBody @Valid DemoIdDto demoIdDto){
		return new ResultVo<>(demoService.select(demoIdDto));
	}
	
	@ApiOperation("修改")
	@RequestMapping(value={"/edit"},method = RequestMethod.POST)
	@ResponseBody
	public ResultVo<Void> edit(@RequestBody @Valid DemoEditDto demoEditDto){
		demoService.edit(demoEditDto);
		return new ResultVo<Void>();
	}
	
	@ApiOperation("删除")
	@RequestMapping(value={"/del"},method = RequestMethod.POST)
	@ResponseBody
	public ResultVo<Void> del(@RequestBody @Valid DemoIdDto demoIdDto){
		demoService.del(demoIdDto);
		return new ResultVo<Void>();
	}

}