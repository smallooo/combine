package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.CmsSubject;

import java.util.List;

public interface HfCallbackService {
    /**
     * 申请单审核结果
     */
    CommonResult asyncreturn();

    /**
     * 业务开通
     */
    CommonResult busiasyncreturn(String keyword, Integer pageNum, Integer pageSize);


    /**
     * reg_result_list
     */
    CommonResult regresultlist();

}
