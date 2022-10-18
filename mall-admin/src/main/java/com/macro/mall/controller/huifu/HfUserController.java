package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONObject;

import com.huifu.bspay.sdk.opps.client.BasePayClient;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.request.V2SupplementaryPictureRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.service.HfShanghuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.Map;

/**
 * 用户管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfUserController")
@Tag(name = "HfUserController", description = "用户管理")
@RequestMapping("/hfuser")
public class HfUserController {

    @Autowired
    private HfShanghuService hfShanghuService;

    @Value("${HF.setRsaPublicKey}")
    private String setRsaPublicKey;

    @ApiOperation(value = "商户统一进件")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam) throws Exception {
        CommonResult umsAdmin = hfShanghuService.interateRegRequest();
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "商户基本信息修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult statusChecking(@Validated @RequestBody UmsAdminParam umsAdminParam) throws Exception {
        CommonResult umsAdmin = hfShanghuService.interateRegRequest();
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "上传图片")
    @RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadphoto() throws BasePayException, IllegalAccessException, IOException {

        V2SupplementaryPictureRequest request = new V2SupplementaryPictureRequest();
        // 业务请求流水号
        request.setReqSeqId("2022012614120615102");
        // 业务请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 图片类型
        request.setFileType("F01");
        // 图片名称
        request.setPicture("身份证.jpeg");

//        //获取项目路径
          File directory = new File("mall-admin/src/main/resources/static/images");


        // 3. 发起API调用
        Map<String, Object> response = BasePayClient.upload(request, new File(directory +"/WechatIMG115.jpeg"));
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return null;
    }




    @ApiOperation(value = "创建代理商")
    @RequestMapping(value = "/createagnet", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createAgnet(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        // 处理前端传入信息  level = accountlevel + 1  parent
        // 开通HF账号  设置代理商角色
        // 开通个人商户信息         开通支付宝支付信息
        // 记录代理商信息





        //CommonResult umsAdmin = hfShanghuService.integrateregrequest();
//        if (umsAdmin == null) {
//            return CommonResult.failed();
//        }
        return CommonResult.success("");
    }


}
