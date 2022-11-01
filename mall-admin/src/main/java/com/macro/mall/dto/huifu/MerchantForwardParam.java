package com.macro.mall.dto.huifu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MerchantForwardParam {
    @NotEmpty
    @ApiModelProperty(value = "phone", required = true)
    private String phone;
    @NotEmpty
    @ApiModelProperty(value = "storeId", required = true)
    private String storeId;

}
