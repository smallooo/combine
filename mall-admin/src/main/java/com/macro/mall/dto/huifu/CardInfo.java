package com.macro.mall.dto.huifu;

import io.swagger.annotations.ApiModelProperty;

public class CardInfo {
    @ApiModelProperty(value = "结算类型 1 对私  2 对私非法人")
    private String card_type;
    @ApiModelProperty(value = "银行所在省")
    private String prov_id;
    @ApiModelProperty(value = "银行所在市")
    private String area_id;
    @ApiModelProperty(value = "结算账户名")
    private String card_name;
    @ApiModelProperty(value = "结算账号")
    private String card_no;
    @ApiModelProperty(value = "持卡人证件有效期类型")
    private String cert_validity_type;
    @ApiModelProperty(value = "持卡人证件有效期（起始）")
    private String cert_begin_date;
    @ApiModelProperty(value = "持卡人证件有效期（截止）")
    private String cert_end_date;
    @ApiModelProperty(value = "持卡人证件号码")
    private String cert_no;
    @ApiModelProperty(value = "持卡人证件类型")
    private String cert_type;
    @ApiModelProperty(value = "银行卡绑定手机号")
    private String mp;

}
