package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.huifu.bspay.sdk.opps.client.BasePayClient;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.request.V2SupplementaryPictureRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.huifu.HFUserParam;
import com.macro.mall.mapper.AddresstoidMapper;
import com.macro.mall.model.Addresstoid;
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
@RequestMapping("/user")
public class HfUserController {
    @Autowired
    private HfShanghuService hfShanghuService;

    @Autowired
    private AddresstoidMapper addresstoidMapper;


    @Value("${HF.setRsaPublicKey}")
    private String setRsaPublicKey;

    @ApiOperation(value = "创建代理商")
    @RequestMapping(value = "/createdelegate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createAgnet(@Validated @RequestBody HFUserParam hfUserParam)  {
        // 处理前端传入信息  level = accountlevel + 1  parent
        System.out.println("接口传入的数据:" + JSON.toJSONString(hfUserParam));
        // 开通HF账号  设置代理商角色
        try {
            CommonResult umsAdmin = hfShanghuService.interateRegRequest(hfUserParam);
        } catch (Exception e) {
            return CommonResult.failed("开通上游商户失败");
        }
        // 开通个人商户信息 开通支付宝支付信息
        addresstoidMapper.insert(new Addresstoid());

        // 记录代理商信息
        return CommonResult.success("");
    }

    @ApiOperation(value = "创建商户")
    @RequestMapping(value = "/createshanghu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody HFUserParam hFUserParam) throws Exception {
        CommonResult umsAdmin = hfShanghuService.interateRegRequest(hFUserParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "查询代理商列表")
    @RequestMapping(value = "/delegatelist", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delegateList(@Validated @RequestBody UmsAdminParam umsAdminParam) {
       // CommonResult umsAdmin = hfShanghuService.integrateregrequest();
//        if (umsAdmin == null) {
//            return CommonResult.failed();
//        }
        //
        return CommonResult.success("");
    }

    @ApiOperation(value = "查询商户列表")
    @RequestMapping(value = "/shanghulist", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult shanghuList(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        // CommonResult umsAdmin = hfShanghuService.integrateregrequest();
//        if (umsAdmin == null) {
//            return CommonResult.failed();
//        }
        //

        return CommonResult.success("");
    }

    @ApiOperation(value = "代理商信息修改")
    @RequestMapping(value = "/modifyDelegate", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modifyDelegate(@Validated @RequestBody UmsAdminParam umsAdminParam) throws Exception {

        return CommonResult.success("");
    }

    @ApiOperation(value = "商户信息修改")
    @RequestMapping(value = "/modifyShanghu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modifyShanghu(@Validated @RequestBody UmsAdminParam umsAdminParam) throws Exception {

        return CommonResult.success("");
    }



    @ApiOperation(value = "上传图片")
    @RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadphoto() throws BasePayException, IllegalAccessException, IOException {
        V2SupplementaryPictureRequest request = new V2SupplementaryPictureRequest();
        request.setReqSeqId("2022012614120615102"); // 业务请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD()); // 业务请求日期
        request.setFileType("F01"); // 图片类型
        request.setPicture("身份证.jpeg"); // 图片名称

        // 从阿里云下载图片 转成file或者字节流
        File directory = new File("mall-admin/src/main/resources/static/images"); //获取项目路径
        Map<String, Object> response = BasePayClient.upload(request, new File(directory +"/WechatIMG451.png"));
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        //保存信息至数据库---
        return null;
    }
}
