package com.hlc.styd.smes.frame.sb.mail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel("简单邮件模型")
@Getter
@Setter
public class EmailDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("发件人")
	private String from;

	@ApiModelProperty("收件人邮箱List")
	private List<String> to;

	@ApiModelProperty("抄送人邮箱")
	private List<String> cc;

	@ApiModelProperty("邮件主题")
	private String subject;

	@ApiModelProperty("邮件内容")
	private String content;

	@ApiModelProperty("文件列表")
	private List<EmailFileDto> filelist;

}
