package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBasicdataQueryRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateRegRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateUpdateRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.controller.huifu.BaseCommonDemo;
import com.macro.mall.dto.huifu.HFUserParam;
import com.macro.mall.mapper.AddresstoidMapper;
import com.macro.mall.service.HfShanghuService;
import com.macro.mall.util.HFUserCreateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.macro.mall.BaseCommonDemo.doExecute;
import static com.macro.mall.util.HFUserModifyUtil.*;

@Service
public class HfShanghuServiceImpl implements HfShanghuService {
    @Autowired
    private AddresstoidMapper addresstoidMapper;

    @Override
    public CommonResult interateRegRequest(HFUserParam hFUserParam) throws Exception {

        HFUserCreateUtil.extracted(hFUserParam,addresstoidMapper);
        return null;
    }


    //商户统一变更接口
    @Override
    public CommonResult integrateUpdateRequest() throws Exception {
        V2MerchantIntegrateUpdateRequest request = new V2MerchantIntegrateUpdateRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32()); // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD()); // 请求日期
        request.setHuifuId("6666000123196564"); // 汇付ID
        request.setUpperHuifuId("6666000122751000"); // 渠道商汇付ID
        request.setDealType("2"); // 业务处理类型
        Map<String, Object> extendInfoMap = getExtendInfos();  // 设置非必填字段
        request.setExtendInfo(extendInfoMap);
        Map<String, Object> response = BaseCommonDemo.doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

    @Override
    public CommonResult getShanghuDetail() throws Exception {
        V2MerchantBasicdataQueryRequest request = new V2MerchantBasicdataQueryRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32()); // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD()); // 请求日期
        request.setHuifuId("6666000123196564"); // 汇付客户Id
        Map<String, Object> extendInfoMap = getExtendInfos(); // 设置非必填字段
        request.setExtendInfo(extendInfoMap);
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

}
