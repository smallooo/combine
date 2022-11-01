package com.macro.mall.controller.huifu;


import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.huifu.MerchantForwardParam;
import com.macro.mall.dto.huifu.MerchantForwardResult;
import com.macro.mall.service.HfShanghuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "HfUserController")
@Tag(name = "HfUserController", description = "用户管理")
@RequestMapping("/pf")
public class SubCustomerController {

    @Autowired
    private HfShanghuService hfShanghuService;


    @ApiOperation(value = "获取注册链接")
    @RequestMapping(value = "/integratereglink", method = RequestMethod.POST)
    @ResponseBody
    public MerchantForwardResult register(@Validated @RequestBody MerchantForwardParam merchantForwardParam) throws Exception {
        MerchantForwardResult data = hfShanghuService.interateRegByWebRequest(merchantForwardParam);
        return data;
    }





}
