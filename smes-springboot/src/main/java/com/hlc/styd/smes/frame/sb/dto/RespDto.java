package com.hlc.styd.smes.frame.sb.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Liang on 2018/11/27.
 */
@Data
public class RespDto<T> {

    private String rspCode;

    private String rspDesc;

    private T data;

}
