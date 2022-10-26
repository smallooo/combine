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
    public CommonResult jspay() {
        CommonResult result = hfTradeService.tradePaymentJspay();
        //固定码


        //单次码  设定金额


        return CommonResult.success(1);
    }

    @ApiOperation("反扫")
    @RequestMapping(value = "/micropay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult micropay() {
        return CommonResult.success(1);
    }




}
