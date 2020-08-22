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
package com.wueasy.example.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增demo
 * @author: fallsea
 * @version 1.0
 */
@Data
public class DemoEditDto implements Serializable{

	private static final long serialVersionUID = -1036617756316951861L;

	@ApiModelProperty(value = "id",required = true)
	@NotNull(message = "id不能为空")
	private Long id;
	
	@ApiModelProperty(value = "名称",required = true)
	@NotBlank(message = "名称不能为空")
	private String name;

	@ApiModelProperty(value = "uuid")
    private String uuid;
	
}
