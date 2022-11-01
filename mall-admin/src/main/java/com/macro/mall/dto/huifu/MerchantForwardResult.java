package com.macro.mall.dto.huifu;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MerchantForwardResult {
    @NotEmpty
    @ApiModelProperty(value = "resp_desc", required = true)
    private String resp_desc;
    @NotEmpty
    @ApiModelProperty(value = "req_seq_id", required = true)
    private String req_seq_id;
    @ApiModelProperty(value = "product_id")
    private String product_id;
    @ApiModelProperty(value = "req_date")
    private String rep_date;
    @ApiModelProperty(value = "resp_code")
    private String resp_code;
    @ApiModelProperty(value = "url")
    private String url;
}
