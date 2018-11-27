package com.hlc.styd.smes.oauth2.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

/**
 * 人员返回对象
 */
@Data
public class OURegisterResponse implements Serializable {

	@JsonProperty("login_name")
	public String login_name;

	@JsonProperty("user_name")
	public String user_name;

	@JsonProperty("user_password")
	public String user_password;

	@JsonProperty("mobile")
	public String mobile;

	@JsonProperty("company")
	public String company;

	@JsonProperty("region_name")
	public String region_name;

	@JsonProperty("department")
	public String department;

	@JsonProperty("employee_type")
	public String employee_type;
}
