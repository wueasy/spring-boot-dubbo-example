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
package com.wueasy.example.core.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页返回对象
 * @author: fallsea
 * @version 1.0
 * @param <T>
 */
@Data
public class PageVo<T> implements Serializable{
	private static final long serialVersionUID = -7374575539896196205L;
	/**
     * 页码
     */
	@ApiModelProperty(value = "页面")
    private int pageNum;
    /**
     * 页面大小
     */
	@ApiModelProperty(value = "每页数量")
    private int pageSize;
    
    /**
     * 总数
     */
	@ApiModelProperty(value = "总数")
    private long total;
    /**
     * 总页数
     */
	@ApiModelProperty(value = "总页数")
    private int pages;
    
    /**
     * 数据
     */
	@ApiModelProperty(value = "数据列表")
    private List<T> list;
    
}
