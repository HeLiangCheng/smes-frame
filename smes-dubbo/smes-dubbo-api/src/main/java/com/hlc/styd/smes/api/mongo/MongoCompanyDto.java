package com.hlc.styd.smes.api.mongo;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by Liang on 2018/11/26.
 *  Mongo存储实体类
 */
@Getter
@Setter
@Document(collection="company")
public class MongoCompanyDto implements Serializable {

    @Field("id")
    @JsonProperty("company_id")
    private Integer id;

    @Field("companyName")
    @JsonProperty("company_name")
    private String companyName;

    @Field("address")
    @JsonProperty("company_address")
    private String address;

    @Field("telphone")
    @JsonProperty("company_telphone")
    private String telphone;

    @Field("staffnum")
    @JsonProperty("company_staffnum")
    private int staffnum;

}
