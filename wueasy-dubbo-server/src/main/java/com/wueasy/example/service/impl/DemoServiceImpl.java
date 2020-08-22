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
package com.wueasy.example.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wueasy.example.core.exception.InvokeException;
import com.wueasy.example.core.vo.PageVo;
import com.wueasy.example.dto.DemoAddDto;
import com.wueasy.example.dto.DemoEditDto;
import com.wueasy.example.dto.DemoIdDto;
import com.wueasy.example.dto.DemoQueryDto;
import com.wueasy.example.dto.DemoQueryPageDto;
import com.wueasy.example.entry.Demo;
import com.wueasy.example.mapper.DemoMapper;
import com.wueasy.example.service.DemoService;
import com.wueasy.example.vo.DemoVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@DubboService(version = "1.0.0")
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private DemoMapper demoMapper;

	@Override
	public void add(DemoAddDto demoAddDto) {
		Demo demo = new Demo();
		BeanUtils.copyProperties(demoAddDto, demo);
		demo.setCreatedTime(new Date());
		demoMapper.insertSelective(demo);
	}

	@Override
	public PageVo<DemoVo> queryPage(DemoQueryPageDto demoQueryPageDto) {
		
		/*********查询方式一，使用通用mapper***********/
		//查询条件
		Example example = new Example(Demo.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(demoQueryPageDto.getName())) {
			criteria.andLike("name", "%"+demoQueryPageDto.getName()+"%");
		}
		//排序
		example.orderBy("id").desc();
		//分页查询
		PageHelper.startPage(demoQueryPageDto.getPageNum(), demoQueryPageDto.getPageSize());
		List<Demo> list = demoMapper.selectByExample(example);
		
		/*********查询方式二，使用编写sql***********/
//		PageHelper.startPage(demoQueryDto.getPageNum(), demoQueryDto.getPageSize());
//		List<Demo> list = demoMapper.queryList(demoQueryDto);
		
		Page<Demo> page = (Page<Demo>)list;
		
		//转换成新的对象
		PageVo<DemoVo> pageVo = new PageVo<>();
		BeanUtils.copyProperties(page, pageVo);
		
		if(null!=list && !list.isEmpty()) {
			List<DemoVo> newList = new ArrayList<>();
			for (Demo demo : list) {
				DemoVo demoVo = new DemoVo();
				BeanUtils.copyProperties(demo, demoVo);
				newList.add(demoVo);
			}
			pageVo.setList(newList);
		}
		return pageVo;
	}

	@Override
	public DemoVo select(DemoIdDto demoIdDto) {
		Demo demo = demoMapper.selectByPrimaryKey(demoIdDto.getId());
		if(null==demo) {
			throw new InvokeException(-1,"记录不存在");
		}
		DemoVo demoVo = new DemoVo();
		BeanUtils.copyProperties(demo, demoVo);
		return demoVo;
	}

	@Override
	public void edit(DemoEditDto demoEditDto) {
		Demo demo = demoMapper.selectByPrimaryKey(demoEditDto.getId());
		if(null==demo) {
			throw new InvokeException(-1,"记录不存在");
		}
		demo = new Demo();
		BeanUtils.copyProperties(demoEditDto, demo);
		demo.setUpdatedTime(new Date());
		demoMapper.updateByPrimaryKeySelective(demo);
	}

	@Override
	public void del(DemoIdDto demoIdDto) {
		Demo demo = demoMapper.selectByPrimaryKey(demoIdDto.getId());
		if(null==demo) {
			throw new InvokeException(-1,"记录不存在");
		}
		demoMapper.deleteByPrimaryKey(demoIdDto.getId());
	}

	@Override
	public List<DemoVo> queryList(DemoQueryDto demoQueryDto) {
		//查询条件
		Example example = new Example(Demo.class);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(demoQueryDto.getName())) {
			criteria.andLike("name", "%"+demoQueryDto.getName()+"%");
		}
		//排序
		example.orderBy("id").desc();
		//分页查询
		List<Demo> list = demoMapper.selectByExample(example);
		if(null!=list && !list.isEmpty()) {
			List<DemoVo> newList = new ArrayList<>();
			for (Demo demo : list) {
				DemoVo demoVo = new DemoVo();
				BeanUtils.copyProperties(demo, demoVo);
				newList.add(demoVo);
			}
			return newList;
		}
		return null;
	}

}
