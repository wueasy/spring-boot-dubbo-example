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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回对象
 * @author: fallsea
 * @version 1.0
 */
@Data
public class ResultVo<T> implements Serializable{

	private static final long serialVersionUID = 7919037519497958291L;

	/**
	 * 错误码，0 成功，其他失败
	 */
	@ApiModelProperty(value = "错误码，0 成功，其他失败")
	private int errorNo = 0;

	/**
	 * 错误消息
	 */
	@ApiModelProperty(value = "错误消息")
	private String errorInfo;

	/**
	 * 返回数据
	 */
	@ApiModelProperty(value = "返回数据")
	private T data;


	public ResultVo()
    {
    }

	/**
	 * 
	 * @author: fallsea
	 * @param errorNo 错误码
	 * @param errorInfo 错误消息
	 */
    public ResultVo(int errorNo, String errorInfo)
    {
        this.errorNo = errorNo;
        this.errorInfo = errorInfo;
    }

	public ResultVo(T data)
    {
    	this.errorNo = 0;
    	this.data = data;
    }

}
