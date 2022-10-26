package com.macro.mall.dto.huifu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 统一进汇
 */
@Getter
@Setter
public class HFUserParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "用户头像")
    private String icon;
    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "备注")
    private String note;

    //用户信息
    @ApiModelProperty(value = "用户姓名")
    private String idname;
    @ApiModelProperty(value = "经营省")
    private String prov;
    @ApiModelProperty(value = "经营市")
    private String area;
    @ApiModelProperty(value = "经营区")
    private String district;
    @ApiModelProperty(value = "经营详细地址")
    private String detailaddr;
    @ApiModelProperty(value = "手机号")
    private String mobileno;
    @ApiModelProperty(value = "身份证号")
    private String idno;
    @ApiModelProperty(value = "持卡人证件有效期类型")
    private String cert_validity_type;
    @ApiModelProperty(value = "持卡人证件有效期（起始）")
    private String cert_begin_date;
    @ApiModelProperty(value = "持卡人证件有效期（截止）")
    private String cert_end_date;

    //银行卡信息
    @ApiModelProperty(value = "银行名称编号")
    private String bank_name_id;
    @ApiModelProperty(value = "银行所在省")
    private String card_prov;
    @ApiModelProperty(value = "银行所在市")
    private String card_area;
    @ApiModelProperty(value = "结算账户名")
    private String card_name;
    @ApiModelProperty(value = "结算账号")
    private String card_no;
    @ApiModelProperty(value = "银行卡绑定手机号")
    private String card_phone_no;

    //照片信息
    @ApiModelProperty(value = "身份证正")
    private String id_img_front;
    @ApiModelProperty(value = "身份证反")
    private String id_img_back;
    @ApiModelProperty(value = "银行卡正")
    private String card_front;
    @ApiModelProperty(value = "银行卡反")
    private String card_back;
    @ApiModelProperty(value = "门店门头照信息或摊位照")
    private String shop_photo_front;
    @ApiModelProperty(value = "门店店内照片或者摊位照侧面")
    private String shop_photo_inside;

    //费率信息
    @ApiModelProperty(value = "是否开通取现")
    private String switch_state;
    @ApiModelProperty(value = "取现手续费率（%）")
    private String fee_rate;
    @ApiModelProperty(value = "提现手续费（固定/元）")
    private String fix_amt;
    @ApiModelProperty(value = "是否交易手续费外扣")
    private String out_fee_flag;

    //ali配置
}
