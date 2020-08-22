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
package com.wueasy.example.service;

import java.util.List;

import com.wueasy.example.core.vo.PageVo;
import com.wueasy.example.dto.DemoAddDto;
import com.wueasy.example.dto.DemoEditDto;
import com.wueasy.example.dto.DemoIdDto;
import com.wueasy.example.dto.DemoQueryDto;
import com.wueasy.example.dto.DemoQueryPageDto;
import com.wueasy.example.vo.DemoVo;

/**
 * demo服务
 * @author: fallsea
 * @version 1.0
 */
public interface DemoService {

	/**
	 * 新增
	 * @author: fallsea
	 * @param demoAddDto
	 */
	void add(DemoAddDto demoAddDto);
	
	/**
	 * 查询分页
	 * @author: fallsea
	 * @param demoQueryDto
	 * @return
	 */
	PageVo<DemoVo> queryPage(DemoQueryPageDto demoQueryPageDto);
	
	/**
	 * 查询单个记录
	 * @author: fallsea
	 * @param demoIdDto
	 */
	DemoVo select(DemoIdDto demoIdDto);
	
	/**
	 * 修改
	 * @author: fallsea
	 * @param demoEditDto
	 */
	void edit(DemoEditDto demoEditDto);
	
	/**
	 * 删除
	 * @author: fallsea
	 * @param demoIdDto
	 */
	void del(DemoIdDto demoIdDto);
	
	/**
	 * 查询列表
	 * @author: fallsea
	 * @param demoQueryDto
	 * @return
	 */
	List<DemoVo> queryList(DemoQueryDto demoQueryDto);
}
