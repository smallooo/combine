package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameQueryRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
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

import java.util.List;
import java.util.Map;

import static com.macro.mall.controller.huifu.BaseCommonDemo.doExecute;


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



        CommonResult result = hfTradeService.register();
        return CommonResult.success(1);
    }

    @Value("${HF.setProcutId}")
    private String setProcutId;

    @ApiOperation("反扫")
    @RequestMapping(value = "/micropay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult micropay() {


        return CommonResult.success(1);
    }


    @ApiOperation("支付宝实名认证查询")
    @RequestMapping(value = "/alistatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult alistatus() throws Exception {

        // 2.组装请求参数
        V2MerchantBusiAliRealnameQueryRequest request = new V2MerchantBusiAliRealnameQueryRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求时间
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID
        request.setHuifuId("6666000123118169");

//        // 设置非必填字段
//        Map<String, Object> extendInfoMap = getExtendInfos();
//        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }


}
