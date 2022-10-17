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

import java.util.List;


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


}
