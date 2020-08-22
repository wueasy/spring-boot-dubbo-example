<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${tableClass.shortClassName}${mapperSuffix}">
  <resultMap id="BaseResultMap" type="${tableClass.fullClassName}">
  	<#if tableClass.allFields??>
        <#list tableClass.allFields as field>
            <#if field.identity >
	 <id column="${field.columnName}" property="${field.fieldName}" />
  			<#else>
	 <result column="${field.columnName}" property="${field.fieldName}" />
  			</#if>
  		</#list>
  	</#if>
  </resultMap>
  
  <sql id="Base_Column_List">
  	<#if tableClass.allFields??>
    	<#assign fs_index = 0 />
       <#list tableClass.allFields as field>
	<#if fs_index ==1>,</#if>${field.columnName}
	<#assign fs_index = 1 />
		</#list>
    </#if>
  </sql>
</mapper>