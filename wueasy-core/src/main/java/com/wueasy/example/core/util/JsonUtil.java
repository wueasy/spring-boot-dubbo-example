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
package com.wueasy.example.core.util;

import com.alibaba.fastjson.JSON;

/**
 * json工具
 * @author: fallsea
 * @version 1.0
 */
public class JsonUtil {

	/**
	 * 把对象转换为json字符串
	 * @author: fallsea
	 * @param value
	 * @return
	 */
	public static String toJsonString(Object value) {
		return JSON.toJSONString(value);
	}
	
	
}
