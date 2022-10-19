package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;

public interface HfTradeService {

    //聚合正扫
    CommonResult tradePaymentJspay();

    //聚合反扫
    CommonResult paymentMicropay();


}
