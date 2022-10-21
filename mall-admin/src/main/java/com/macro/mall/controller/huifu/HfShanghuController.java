package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONArray;
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

    @ApiOperation("支付宝实名认证查询")
    @RequestMapping(value = "/alistatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult alistatus() throws Exception {
        V2MerchantBusiAliRealnameQueryRequest request = new V2MerchantBusiAliRealnameQueryRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        request.setHuifuId("6666000123196564");
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return CommonResult.success(1);
    }


    private static String getContactPersonInfo() {
        JSONObject dto = new JSONObject();
        // 联系人身份证号码
        dto.put("id_card_number", "130827198408270012");
        // 联系人姓名
        dto.put("name", "李铁航");
        // 联系人手机号
        dto.put("mobile", "15900777754");

        return dto.toJSONString();
    }


    private static String getSupportCredentials() {
        JSONObject dto = new JSONObject();
        // 小微经营类型
        dto.put("micro_biz_type", "MICRO_TYPE_STORE");
        // 门店名称
        dto.put("store_name", "肯德基共富新村店");
        // 门店省市编码
        dto.put("province_code", "310000");
        // 门店省份
        dto.put("province", "上海");
        // 门店市行政区号
        dto.put("city_code", "310100");
        // 门店城市
        dto.put("city", "上海市");
        // 门店街道区号
        dto.put("district_code", "310107");
        // 门店街道
        dto.put("district", "普陀区");
        // 门店场所填写门店详细地址
        dto.put("store_address", "消息路");
        // 门店门头照信息或摊位照
        dto.put("store_door_img", "afce08c5-1548-30f8-bf70-1752c3012f66");
        // 门店店内照片或者摊位照侧面
        dto.put("store_inner_img", "51dd13bb-6268-36d0-ac84-c4cdc19eccba");

        return dto.toJSONString();
    }

    private static String getQualificationInfoList() {
        JSONObject dto = new JSONObject();
        // 行业类目id
        dto.put("mcc_code", "5331");
        // 行业经营许可证资质照片
        dto.put("image_list", "afce08c5-1548-30f8-bf70-1752c3012f66,51dd13bb-6268-36d0-ac84-c4cdc19eccba");

        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }

    private static String getAuthIdentityInfo() {
        JSONObject dto = new JSONObject();
        // 主体类型
        dto.put("business_type", "0");
        // 是否金融机构
        dto.put("finance_institution_flag", "N");
        // 证照类型
        dto.put("certificate_type", "BUSINESS_CERT");
        // 单位证明函照片
        dto.put("company_prove_copy", "71da066c-5d15-3658-a86d-4e85ee67808a");
        // 辅助证明材料信息
        dto.put("support_credentials", getSupportCredentials());
        // 经营许可证
       // dto.put("qualification_info_list", getQualificationInfoList());

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
        request.setHuifuId("6666000123196564");
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
