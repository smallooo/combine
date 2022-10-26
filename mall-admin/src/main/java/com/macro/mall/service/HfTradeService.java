package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;

public interface HfTradeService {

    //聚合正扫
    CommonResult tradePaymentJspay();

    //聚合反扫
    CommonResult paymentMicropay();

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
