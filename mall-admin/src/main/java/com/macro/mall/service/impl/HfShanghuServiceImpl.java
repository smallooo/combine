package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBasicdataQueryRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateRegRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateUpdateRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.HfShanghuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.macro.mall.BaseCommonDemo.doExecute;


@Service
public class HfShanghuServiceImpl implements HfShanghuService {

    private static String getAliConfList() {
        JSONObject dto = new JSONObject();
        // 支付场景
        dto.put("pay_scene", "1");
        // 手续费（%）
        dto.put("fee_rate", "0.38");
        // 商户经营类目
        dto.put("mcc", "2015063000020189");
        // 子渠道号
        dto.put("pay_channel_id", "JQF00001");
        // 拟申请的间联商户等级
        dto.put("indirect_level", "INDIRECT_LEVEL_M3");
        // 交易手续费外扣时的账户类型
        dto.put("out_fee_acct_type", "01");
        // 交易手续费外扣汇付ID
        dto.put("out_fee_huifuid", "6666000105215340");
        // 是否交易手续费外扣
        dto.put("out_fee_flag", "1");

        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }
    private static Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
//        // 经营简称
//        extendInfoMap.put("short_name", "姜雨");
//        // 小票名称
//        extendInfoMap.put("receipt_name", "汇付天下");
//        // 商户英文名称
//        extendInfoMap.put("mer_en_name", "huifu");
//        // 所属行业
//        extendInfoMap.put("mcc", "7273");
        // 营业执照类型
//        extendInfoMap.put("license_type", "NATIONAL_LEGAL_MERGE");
//        // 营业执照编号
//        extendInfoMap.put("license_code", "914403001921834459");
//        // 营业执照有效期类型
//        extendInfoMap.put("license_validity_type", "0");
//        // 营业执照有效期开始日期
//        extendInfoMap.put("license_begin_date", "19831108");
//        // 营业执照有效期截止日期
//        extendInfoMap.put("license_end_date", "20380831");
        // 注册详细地址
        extendInfoMap.put("reg_detail", "深圳市宝安区新安街道海旺社区N26区海秀路2021号荣超滨海大厦A座2111");
        // 注册省
        extendInfoMap.put("reg_prov_id", "310000");
        // 注册市
        extendInfoMap.put("reg_area_id", "310100");
        // 注册区
        extendInfoMap.put("reg_district_id", "310104");
        // 客服电话
        extendInfoMap.put("service_phone", "13567889160");
//        // 商户主页URL
//        extendInfoMap.put("mer_url", "http://www.baidu.com");
//        // 商户ICP备案编号
//        extendInfoMap.put("mer_icp", "苏ICP备15042526号");
//        // 开户许可证核准号
//        extendInfoMap.put("open_licence_no", "123456789");
//        // 管理员账号
//        extendInfoMap.put("login_name", "LG02022072707540497330158089012");
//        // 是否发送短信通知商户标识
//        extendInfoMap.put("sms_send_flag", "1");
//        // 取现配置列表
//        extendInfoMap.put("cash_config", getCashConfig());
//        // 结算配置实体
//        extendInfoMap.put("settle_config", getSettleConfig());

        // 支付宝配置对象
        extendInfoMap.put("ali_conf_list", getAliConfList());

        // 异步消息接收地址
        extendInfoMap.put("async_return_url", "rmq://C_SSPM_YMFZ_AUDIT");
        // 业务开通结果异步消息接收地址
        extendInfoMap.put("busi_async_return_url", "virgo://http://192.168.85.157:30031/sspm/testVirgo");
        // 交易异步应答地址
        extendInfoMap.put("recon_resp_addr", "archer://C_SSPM_NSPOSM_BUSIRESULT");
//        // 签约人
//        extendInfoMap.put("sign_user_info", getSignUserInfo());
        // 商户业务类型
        extendInfoMap.put("mer_bus_type", "");
        return extendInfoMap;
    }


    private static String getContactInfo() {
        JSONObject dto = new JSONObject();
        // 联系人姓名
        dto.put("contact_name", "何东明");
        // 联系人手机号
        dto.put("contact_mobile_no", "13567889160");
        // 联系人电子邮箱
        dto.put("contact_email", "dongming1.he@icloud.com");
        // 联系人身份证号
        dto.put("contact_cert_no", "13567889160");

        return dto.toJSONString();
    }

    private static String getCardInfo() {
        JSONObject dto = new JSONObject();
        // 结算类型
        dto.put("card_type", "2");
        // 银行所在省
        dto.put("prov_id", "310000");
        // 银行所在市
        dto.put("area_id", "310100");
        // 结算账户名
        dto.put("card_name", "何东明");
        // 结算账号
        dto.put("card_no", "6214835765798853");
//        // 银行编码
//        dto.put("bank_code", "01050000");
//        // 联行号
//        dto.put("branch_code", "105290075067");
//        // 支行名称
//        dto.put("branch_name", "中国建设银行股份有限公司上海五角场支行");
        // 持卡人证件有效期类型
        dto.put("cert_validity_type", "1");
        // 持卡人证件有效期（起始）
        dto.put("cert_begin_date", "20210201");
        // 持卡人证件有效期（截止）
        dto.put("cert_end_date", "");
        // 持卡人证件号码
        dto.put("cert_no", "110101199305182000");
        // 持卡人证件类型
        dto.put("cert_type", "00");
        // 银行卡绑定手机号
        dto.put("mp", "1865590000");

        return dto.toJSONString();
    }




    //商户统一进件接口
    @Override
    public CommonResult interateRegRequest() throws Exception {

        // 2.组装请求参数
        V2MerchantIntegrateRegRequest request = new V2MerchantIntegrateRegRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 渠道商汇付id
        request.setUpperHuifuId("6666000105215341");
        // 公司类型
        request.setEntType("3");
        // 商户名称
        request.setRegName("天马微电子股份有限公司");
        // 经营类型
        request.setBusiType("1");
        // 经营详细地址
        request.setDetailAddr("深圳市宝安区新安街道海旺社区N26区海秀路2021号荣超滨海大厦A座2111");
        // 经营省
        request.setProvId("310000");
        // 经营市
        request.setAreaId("310100");
        // 经营区
        request.setDistrictId("310104");
        // 联系人信息
        request.setContactInfo(getContactInfo());
        // 卡信息配置实体
        request.setCardInfo(getCardInfo());

        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));




        // 发起分账申请





        return null;
    }





    //商户统一变更接口
    @Override
    public CommonResult integrateUpdateRequest() throws Exception {

        // 2.组装请求参数
        V2MerchantIntegrateUpdateRequest request = new V2MerchantIntegrateUpdateRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID
        request.setHuifuId("6666000105240784");
        // 渠道商汇付ID
        request.setUpperHuifuId("6666000105215341");
        // 业务处理类型
        request.setDealType("1");

        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return null;
    }

    @Override
    public CommonResult getShanghuDetail() throws Exception {
        // 2.组装请求参数
        V2MerchantBasicdataQueryRequest request = new V2MerchantBasicdataQueryRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付客户Id
        request.setHuifuId("6666000107932702");

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


    //聚合正扫
    @Override
    public CommonResult tradePaymentJspay() throws Exception {

        //        // 2. 组装交易参数
//        AuthCodePayRequest request = new AuthCodePayRequest("20210623", "20210705170736631111111111112", "0.01", "287606928207260511", "测试商品");
//        // 3.拓展参数 (可选)
//        // 该笔交易的异步通知地址（http/https异步通知地址，必须以virgo://开头）
//        request.addExtendInfo("notify_url", "virgo://http://www.baidu.com");
//
//        Map<String, Object> pullPayInfo = new HashMap<>();
//        try {
//           // System.out.println("聚合反扫请求参数：" + JSON.toJSONString(dataMap));
//            // 单商户模式
//            pullPayInfo = BasePayClient.request(request);
//            System.out.println("聚合反扫返回参数：" + JSON.toJSONString(pullPayInfo));
//        } catch (BasePayException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
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


        return null;
    }

    //聚合反扫
    @Override
    public CommonResult paymentMicropay() throws Exception {

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
