package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.huifu.HFUserParam;

public interface AUserCreateService {

    CommonResult createUser(HFUserParam hfUserParam) throws Exception;
}
