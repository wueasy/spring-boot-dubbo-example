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

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	 
	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        for (int i = converters.size() - 1; i >= 0; i--) {
	            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
	                converters.remove(i);
	            }
	        }
	        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
	        //自定义fastjson配置
	        FastJsonConfig config = new FastJsonConfig();
	        config.setSerializerFeatures(
//	                SerializerFeature.WriteMapNullValue,        // 是否输出值为null的字段,默认为false,我们将它打开
//	                SerializerFeature.WriteNullListAsEmpty,     // 将Collection类型字段的字段空值输出为[]
//	                SerializerFeature.WriteNullStringAsEmpty,   // 将字符串类型字段的空值输出为空字符串
//	                SerializerFeature.WriteNullNumberAsZero,    // 将数值类型字段的空值输出为0
//	                SerializerFeature.WriteDateUseDateFormat,
	                SerializerFeature.DisableCircularReferenceDetect    // 禁用循环引用
	        );
	        fastJsonHttpMessageConverter.setFastJsonConfig(config);
	        // 添加支持的MediaTypes;不添加时默认为*/*,也就是默认支持全部
	        // 但是MappingJackson2HttpMessageConverter里面支持的MediaTypes为application/json
	        // 参考它的做法, fastjson也只添加application/json的MediaType
	        List<MediaType> fastMediaTypes = new ArrayList<>();
	        fastMediaTypes.add(MediaType.APPLICATION_JSON);
	        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
	        converters.add(fastJsonHttpMessageConverter);
	    }
}
