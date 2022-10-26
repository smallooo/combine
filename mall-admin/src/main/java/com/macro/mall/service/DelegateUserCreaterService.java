package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.huifu.HFUserParam;

public interface DelegateUserCreaterService {

    CommonResult createDelegate(HFUserParam hfUserParam) throws Exception;

    CommonResult createShanghu(HFUserParam hFUserParam) throws Exception;
}
