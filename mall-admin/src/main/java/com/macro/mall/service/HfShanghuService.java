package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.huifu.HFUserParam;

public interface HfShanghuService {

    /**
     * 在汇付平台统一进件
     * 开通商户账号和开通支付宝支付
     */
    CommonResult interateRegRequest(HFUserParam hFUserParam) throws Exception;

    /**
     * 商户统一变更接口
     */
    CommonResult integrateUpdateRequest() throws Exception;

    /*
        查询汇付平台用户信息
     */
    CommonResult getShanghuDetail() throws Exception;




}
