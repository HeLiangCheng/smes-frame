package com.hlc.styd.smes.oauth2.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * 人员请求对象
 */
@Data
public class OURegisterRequest implements Serializable {

	@JsonProperty("login_name")
	public String uid;

	@JsonProperty("user_name")
	public String sn;

	@JsonProperty("user_password")
	public String password;

	@JsonProperty("mobile")
	public String mobile;

	@JsonProperty("company")
	public String company;

	@JsonProperty("region_name")
	public String regionName;

	@JsonProperty("department")
	public String department;

	@JsonProperty("employee_type")
	public String employeeType;
}
