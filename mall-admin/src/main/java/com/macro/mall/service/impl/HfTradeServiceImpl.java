package com.macro.mall.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2TradePaymentJspayRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.HfTradeService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.macro.mall.BaseCommonDemo.doExecute;

@Service
public class HfTradeServiceImpl implements HfTradeService {

    @Override
    public CommonResult tradePaymentJspay() {
        V2TradePaymentJspayRequest request = new V2TradePaymentJspayRequest();
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 商户号
        request.setHuifuId("6666000123127789");
        // 交易类型
        request.setTradeType("A_NATIVE");
        // 交易金额
        request.setTransAmt("0.50");
        // 商品描述
        request.setGoodsDesc("聚合正扫消费");

//        // 设置非必填字段
//        Map<String, Object> extendInfoMap = getExtendInfos();
//        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = null;
        try {
            response = doExecute(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("返回数据:" + JSONObject.toJSONString(response));



        return null;
    }

    @Override
    public CommonResult paymentMicropay() {
        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        Calendar cl = Calendar.getInstance();
//        String nowStr = sdf.format(cl.getTime());
//
//        System.out.println("setProcutId" + setProcutId);
//
//        // 参数组装
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        // 请求流水号，需保证当天商户下唯一，推荐采用日期时间+几位流水号的形式
//        dataMap.put("req_seq_id", nowStr + "01234567890");
//        // 请求日期，请求接口的日期，因服务器时间可能有差异，允许前后1天
//        dataMap.put("req_date", new SimpleDateFormat("yyyyMMdd").format(cl.getTime()));
//        // 系统编号，由汇付分配
//        dataMap.put("sys_id", "6666000122751000");
//        // 商户订单号，需保证商户下唯一，推荐采用日期时间+几位流水号的形式
//        dataMap.put("mer_ord_id", nowStr + "1234567890");
//        // 分配商户号
//        dataMap.put("huifu_id", "6666000122840825");
//        // 渠道号，若需使用自有渠道请联系业务对接人
//        dataMap.put("bank_channel_no", "");
//        // 交易金额
//        dataMap.put("trans_amt", "0.02");
//        // 商品描述
//        dataMap.put("goods_desc", "测试商品");
//        // 支付授权码,本接口会自动识别微信、支付宝、银联二维码
//         dataMap.put("auth_code", "DemoConstants.ALIPAY_AUTH_CODE");
//        //dataMap.put("auth_code", "DemoConstants.WX_AUTH_CODE");
//        // dataMap.put("auth_code", DemoConstants.UNIONPAY_AUTH_CODE);
//        // 风控信息
//        Map<String, String> riskMngInfo = new HashMap<>();
//        riskMngInfo.put("subTradeType", "4300");
//        Map<String, Object> riskCheckInfo = new HashMap<>();
//        riskCheckInfo.put("riskMngInfo", riskMngInfo);
//        riskCheckInfo.put("ipAddr", "139.207.19.246");
//        // 注意，风控信息为JSON字符串
//        // dataMap.put("risk_check_info", JSON.toJSONString(riskCheckInfo));
//        dataMap.put("risk_check_info", riskCheckInfo);
//        // 设备信息
//        JSONObject terminalDeviceInfo = new JSONObject();
//        terminalDeviceInfo.put("device_type", "4");
//        terminalDeviceInfo.put("device_ip", "139.207.19.246");
//        dataMap.put("terminal_device_info", terminalDeviceInfo);
//        // 异步通知地址
//        dataMap.put("notify_url", "virgo://http://124.253.142.142");
//        // 交易有效期
//        cl.add(Calendar.MINUTE, 2);
//        dataMap.put("time_expire", sdf.format(cl.getTime()));
//        // 是否禁止用户使用信用卡支付。默认不禁用，若禁止请填1
//        dataMap.put("limit_pay", "0");
//        // 是否延时交易,1为延迟 0为不延迟
//        dataMap.put("is_delay_acct", "0");
//        // 传入分帐遇到优惠的处理规则 1-按比例分 2-按顺序保障 3-只给交易商户
//        dataMap.put("term_div_coupon_type", "3");
//        // 分账串，无需实时分账时可不传
//        JSONObject acctSplitBunch = new JSONObject();
//        JSONArray acctInfos = new JSONArray();
//        // 分账方1
//        JSONObject acctInfo = new JSONObject();
//        acctInfo.put("huifu_id", "6666000122840825");
//        acctInfo.put("div_amt", "0.01");
//        acctInfos.add(acctInfo);
//        // 分账方2
//        acctInfo = new JSONObject();
//        acctInfo.put("huifu_id", "6666000122840825");
//        acctInfo.put("div_amt", "0.01");
//        acctInfos.add(acctInfo);
//        acctSplitBunch.put("acct_infos", acctInfos);
//        dataMap.put("acct_split_bunch", acctSplitBunch);
//        // 商户私有域
//        dataMap.put("mer_priv", "");
//        // 微信扩展参数集合
//        dataMap.put("wx_data", "");
//        // 支付宝扩展参数集合
//        dataMap.put("alipay_data", "");
//        // 银联扩展参数集合
//        dataMap.put("unionpay_data", "");
//        // 商户私有域
//        dataMap.put("mer_priv", "");
//        // 手续费类型 01:标准费率线上,02:标准费率线下,03:非盈利费率,04:缴费费率,05:保险费率,06:行业活动费率,07:校园餐饮费率,08:K12中小幼费率
//        // 不送时取业务入驻配置的默认费率
//        dataMap.put("pay_scene", "02");
//
//        Map<String, Object> pullPayInfo = new HashMap<>();
//        try {
//            System.out.println("聚合反扫请求参数：" + JSON.toJSONString(dataMap));
//            // 单商户模式可不指定merchantKey，会自动套用default配置
//            pullPayInfo = BasePayClient.request(dataMap, "top.trans.authCodePay");
//            // 多商户模式需指定merchantKey
//            // pullPayInfo = BasePayClient.request(dataMap, "top.trans.authCodePay", "merchantKey1");
//            System.out.println("聚合反扫返回参数：" + JSON.toJSONString(pullPayInfo));
//        } catch (BasePayException e) {
//            e.printStackTrace();
//        }
//
//
//        String subRespCode = (String) pullPayInfo.get("sub_resp_code");
//        if ("00000000".equals(subRespCode)) {
//            // 业务处理成功
//            System.out.println("处理成功");
//        } else if ("00000100".equals(subRespCode)) {
//            // 聚合反扫返回处理中，等待异步通知结果
//            // 前台如需要交易结果展示可调用交易查询来获取后续交易状态
//        } else {
//            String subRespDesc = (String) pullPayInfo.get("sub_resp_desc");
//            // 业务处理失败
//            System.out.println("处理失败，失败信息："  + subRespDesc);
//        }
//
//
//
//
//        CommonResult result = hfTradeService.register();

        return null;
    }
}
