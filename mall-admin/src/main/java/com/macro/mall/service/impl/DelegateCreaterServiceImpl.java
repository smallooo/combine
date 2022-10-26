package com.macro.mall.service.impl;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.huifu.HFUserParam;
import com.macro.mall.service.DelegateUserCreaterService;
import com.macro.mall.service.HfShanghuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelegateCreaterServiceImpl implements DelegateUserCreaterService {

    @Autowired
    private HfShanghuService hfShanghuService;

    @Override
    public CommonResult createDelegate(HFUserParam hFUserParam) throws Exception {
        // 如果是创建代理商
        hfShanghuService.interateRegRequest(hFUserParam);
        // 创建成功后写入代理商表
        return null;
    }

    @Override
    public CommonResult createShanghu(HFUserParam hFUserParam) throws Exception {
        // 创建是商户
        hfShanghuService.interateRegRequest(hFUserParam);
        //创建成功后写入商户表
        return null;
    }
}
