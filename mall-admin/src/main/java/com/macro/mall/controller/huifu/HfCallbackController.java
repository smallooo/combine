package com.macro.mall.controller.huifu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.utils.RsaUtils;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Controller
@Api(tags = "HfNotifyController")
@Tag(name = "HfNotifyController", description = "通知回调")
@RequestMapping("/hfcallback")
public class HfCallbackController {
    @ApiOperation(value = "申请单审核结果")
    @RequestMapping(value = "/asyncreturn", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult asyncreturn() {

        return CommonResult.success(null);
    }

    @ApiOperation(value = "业务开通")
    @RequestMapping(value = "/busiasyncreturn", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult busiasyncreturn() {

        return CommonResult.success(null);
    }

    @ApiOperation(value = "reg_result_list")
    @RequestMapping(value = "/regresultlist", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult regresultlist() {

        return CommonResult.success(null);
    }

    @RequestMapping("/asyncMessageHand")
    public String print(@RequestBody String messageBody) {
        JSONObject jsonObject = JSONObject.parseObject(messageBody);
        try {
            // 验签请参sign
            String sign = jsonObject.getString("sign");
            // 使用汇付公钥验签
            String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt5hd0XSAusIkRYMEXv6ZHlCU9XIQsgJWmnarxJamVQ/4hjCeefUoD/PX7cH+pmw6IMhDYLSrbM8Jdcfz4cxZl1cOLEchpYEkRehr6hER1/bJqWTLDDEWzPSWqcwpQLCW70XueJh2LHu/u2EillRUf8RT4aiO4zobujlUhblSgAYI7M8/wH2ehva8rlAQ2go8evhZcWW1WafW5IjmXbYqAyXF/swukG4tTFAXrtwdUVZAT4jJphVfdO0UbxMng4Kv9S/K9Hh+H1mtwb2SKJwAmfTWMt9YVJFk00jPhFJsxqliGxY0TMjb9wC2Y8A1eElZWP4VcWQoKe+Sx1kg37KolQIDAQAB";
            if (!RsaUtils.verify(messageBody, pubKey, sign)) {
                // 验签失败处理
                return "";
            }
            JSONObject dataObj = JSON.parseObject(messageBody);
            String subRespCode = dataObj.getString("sub_resp_code");
            String reqSeqId = dataObj.getString("req_seq_id");
            if ("00000000".equals(subRespCode)) {
                // 业务处理成功
                LOGGER.info("处理成功");

            } else {
                // 业务处理失败
                LOGGER.info("处理失败");
            }
            return "RECV_ORD_ID_" + reqSeqId;
        } catch (Exception e) {
            LOGGER.info(messageBody);
        }

        // 获取事件类型
        String eventDefineNo = jsonObject.getString("eventDefineNo");
        // 对不同的事件类型做业务处理 注：demo仅以三个支付事件类型作为参考，具体全部事件类型请参考webhook文档
        switch (eventDefineNo) {
            case "pay.ali_js":
                // 支付宝JS 相关业务处理
                break;
            case "pay.ali_qr":
                // 支付宝正扫 相关业务处理
                break;
            case "pay.union_js":
                // 银联JS支付 相关业务处理
                break;
            default:
                // 未知业务处理
        }
        return "ok";
    }
}
