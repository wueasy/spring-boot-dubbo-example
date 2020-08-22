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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 * @author: fallsea
 * @version 1.0
 */
@Configuration
public class CorsConfig {
    
    @Bean
	public CorsFilter corsFilter() {
		// 添加CORS配置信息
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 放行哪些原始域
		corsConfiguration.addAllowedOrigin("*");
		// 是否发送cookie信息
		corsConfiguration.setAllowCredentials(false);
		// 放行哪些原始域（请求方式）
		corsConfiguration.addAllowedMethod("*");
		// 放行哪些原始域（头部信息）
		corsConfiguration.addAllowedHeader("*");
		// 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
		corsConfiguration.addExposedHeader(HttpHeaders.ACCEPT);

		// 添加映射路径
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		// 返回新的CorsFileter
		return new CorsFilter(source);
	}
}
