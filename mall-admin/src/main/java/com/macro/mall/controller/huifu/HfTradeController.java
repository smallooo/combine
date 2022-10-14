package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSON;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.HfTradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 支付管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfTradeController")
@Tag(name = "HfTradeController", description = "交易管理")
@RequestMapping("/trade/")
public class HfTradeController {
    @Autowired
    private HfTradeService hfTradeService;

    @ApiOperation("正扫")
    @RequestMapping(value = "/jspay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult jspay(@RequestBody List<PmsSkuStock> skuStockList) {

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

        CommonResult result = hfTradeService.register();
        return CommonResult.success(1);
    }

    @Value("${HF.setProcutId}")
    private String setProcutId;

    @ApiOperation("反扫")
    @RequestMapping(value = "/micropay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult micropay() {
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
        return CommonResult.success(1);
    }


}
