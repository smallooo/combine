package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;

public interface HfShanghuService {

    /**
     * 在汇付平台统一进件
     * 开通商户账号和开通支付宝支付
     */
    CommonResult interateRegRequest() throws Exception;

    /**
     * 商户统一变更接口
     */
    CommonResult integrateUpdateRequest() throws Exception;

    /*
        查询汇付平台用户信息
     */
    CommonResult getShanghuDetail() throws Exception;

    //商户分账配置查询
    CommonResult split() throws Exception;

    //账户余额查询
    CommonResult acctpaymentBalance() throws Exception;

    //余额支付
    CommonResult acctpaymentPay() throws Exception;

    //交易、结算文件查询
    CommonResult checkFile() throws Exception;

    //交易确认查询接口
    CommonResult paymentDelaytransConfirm() throws Exception;

    //取现接口
    CommonResult settlementEnchashment() throws Exception;

    //交易分账明细查询接口
    CommonResult transSplitQuery() throws Exception;



}
