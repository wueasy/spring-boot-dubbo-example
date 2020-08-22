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
package com.wueasy.example.entry;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "demo")
public class Demo implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 名称
     */
    private String name;

    private String uuid;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    private static final long serialVersionUID = 1L;
}