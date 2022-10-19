package com.macro.mall.dto.huifu;


import io.swagger.annotations.ApiModelProperty;



public class ContactInfo {

    @ApiModelProperty(value = "姓名")
    private String contactname;
    @ApiModelProperty(value = "手机号")
    private String mobileno;
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    @ApiModelProperty(value = "身份证号")
    private String certno;
}
