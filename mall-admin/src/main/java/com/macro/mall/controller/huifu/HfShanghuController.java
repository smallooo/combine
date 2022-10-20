package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameApplyRequest;
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

import java.util.HashMap;
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
        V2MerchantBusiAliRealnameQueryRequest request = new V2MerchantBusiAliRealnameQueryRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        request.setHuifuId("6666000123127789");
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }


    private static String getLegalPersonInfo() {
        JSONObject dto = new JSONObject();
        // 证件持有人类型
        dto.put("legal_type", "LEGAL");
        // 证件类型
        dto.put("card_type", "00");
        // 法人姓名
        dto.put("person_name", "李少伟");
        // 证件号码
        dto.put("card_no", "350628198306200079");
        // 证件生效时间
        dto.put("effect_time", "20200724");
        // 证件过期时间
        dto.put("expire_time", "20400724");
        // 证件正面照
        dto.put("card_front_img", "856ec6fa-5632-3646-8e9f-4ee52cd0a7b1");
        // 证件反面照
        dto.put("card_back_img", "9b73a96e-12b6-37b9-916a-59a611713b80");
        // 授权函照片
        // 是否为受益人

        return dto.toJSONString();
    }





    private static Map<String, Object> getaliExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
//        // 子渠道号
//        extendInfoMap.put("pay_channel_id", "10000001");
        // 业务开通类型
        extendInfoMap.put("pay_scene", "1");
        // 法人身份信息
        extendInfoMap.put("legal_person_info", getLegalPersonInfo());
        // 受益人信息
        return extendInfoMap;
    }

    private static String getContactPersonInfo() {
        JSONObject dto = new JSONObject();
        // 联系人身份证号码
        dto.put("id_card_number", "350628198306200079");
        // 联系人姓名
        dto.put("name", "李少伟");
        // 联系人手机号
        dto.put("mobile", "15606044444");

        return dto.toJSONString();
    }

    private static String getAuthIdentityInfo() {
        JSONObject dto = new JSONObject();
        // 主体类型
        dto.put("business_type", "0");
        // 是否金融机构
        dto.put("finance_institution_flag", "N");

        return dto.toJSONString();
    }


    @ApiOperation("支付宝实名认证申请")
    @RequestMapping(value = "/alisverify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult alisverify() throws Exception {
        // 2.组装请求参数
        V2MerchantBusiAliRealnameApplyRequest request = new V2MerchantBusiAliRealnameApplyRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求时间
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID
        request.setHuifuId("6666000123127789");
//        // 联系人信息
        request.setContactPersonInfo(getContactPersonInfo());
        // 主体信息
        request.setAuthIdentityInfo(getAuthIdentityInfo());

        // 设置非必填字段
       // Map<String, Object> extendInfoMap = getExtendInfos();
       // request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }
}
