package com.macro.mall.controller.huifu;


import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
