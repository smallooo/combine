package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameQueryRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.HfShanghuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.macro.mall.controller.huifu.BaseCommonDemo.doExecute;

/**
 * 商户管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfShanghuController")
@Tag(name = "HfShanghuController", description = "商户管理")
@RequestMapping("/hfshanghu")
public class HfShanghuController {
    @Autowired
    private HfShanghuService hfShanghuService;

    @ApiOperation("个人商户注册")
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult register() throws Exception {
        hfShanghuService.interateRegRequest();
        return CommonResult.success(1);
    }

    @ApiOperation(value = "查询商户信息")
    @RequestMapping(value = "/detailinfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList() throws Exception {
        hfShanghuService.getShanghuDetail();
        return CommonResult.success(1);
    }

    @ApiOperation(value = "商户业务开通修改")
    @RequestMapping(value = "/busimodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult busimodify() throws Exception {
        hfShanghuService.integrateUpdateRequest();
        return CommonResult.success(1);
    }

    @ApiOperation(value = "图片上传")
    @RequestMapping(value = "/photoupload", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult photoupload() {
        //上传汇付
        //上传阿里云
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态查询")
    @RequestMapping(value = "/statusquery", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusquery() throws Exception {
        hfShanghuService.getShanghuDetail();
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态变更")
    @RequestMapping(value = "/statusmodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusmodify() {
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
