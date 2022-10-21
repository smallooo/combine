package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBasicdataQueryRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateRegRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateUpdateRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.controller.huifu.BaseCommonDemo;
import com.macro.mall.service.HfShanghuService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.macro.mall.BaseCommonDemo.doExecute;
import static com.macro.mall.util.HFutil.*;


@Service
public class HfShanghuServiceImpl implements HfShanghuService {

    //商户统一进件接口 //统一进汇
    @Override
    public CommonResult interateRegRequest() throws Exception {
        V2MerchantIntegrateRegRequest request = new V2MerchantIntegrateRegRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 渠道商汇付id
        request.setUpperHuifuId("6666000122751000");
        // 公司类型 0 个人商户
        request.setEntType("0");
        // 商户名称
        request.setRegName("李铁航");
        // 经营类型 1 实体
        request.setBusiType("1");
        // 经营省
        request.setProvId("350000");
        // 经营市
        request.setAreaId("350600");
        // 经营区
        request.setDistrictId("350603");
        // 经营详细地址
        request.setDetailAddr("福建省漳州市龙文区中山东路1188号");
        // 联系人信息
        request.setContactInfo(getContactInfo());


        // 经营详细地址
        request.setCardInfo(getCardInfo());
        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);
        // 3. 发起API调用
        Map<String, Object> response = BaseCommonDemo.doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }


    //商户统一变更接口
    @Override
    public CommonResult integrateUpdateRequest() throws Exception {
        V2MerchantIntegrateUpdateRequest request = new V2MerchantIntegrateUpdateRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID
        request.setHuifuId("6666000123196564");
        // 渠道商汇付ID
        request.setUpperHuifuId("6666000122751000");
        // 业务处理类型
        request.setDealType("2");

        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = BaseCommonDemo.doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

    @Override
    public CommonResult getShanghuDetail() throws Exception {
        V2MerchantBasicdataQueryRequest request = new V2MerchantBasicdataQueryRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付客户Id
        request.setHuifuId("6666000123196564");
        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);
        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return null;
    }

    //商户分账配置查询
    @Override
    public CommonResult split() throws Exception {

        return null;
    }

    //账户余额查询
    @Override
    public CommonResult acctpaymentBalance() throws Exception {
        return null;
    }

    //余额支付
    @Override
    public CommonResult acctpaymentPay() throws Exception {
        return null;
    }

    //交易、结算文件查询
    @Override
    public CommonResult checkFile() throws Exception {
        return null;
    }

    //交易确认查询接口
    @Override
    public CommonResult paymentDelaytransConfirm() throws Exception {
        return null;
    }

    //取现接口
    @Override
    public CommonResult settlementEnchashment() throws Exception {
        return null;
    }

    //交易分账明细查询接口
    @Override
    public CommonResult transSplitQuery() throws Exception {
        return null;
    }
}
