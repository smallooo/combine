package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameApplyRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameQueryRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.huifu.HFUserParam;
import com.macro.mall.service.AUserCreateService;
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

    @Autowired
    private AUserCreateService aUserCreateService;

    @ApiOperation("代理商和商户注册")
    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult creatuser(@RequestBody HFUserParam hfUserParam) throws Exception {
        System.out.println("返回数据:" + hfUserParam.getUsername() + hfUserParam.getPassword());
        aUserCreateService.createUser(hfUserParam);
        return CommonResult.success(1);
    }

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
        // 辅助证明材料信息
        dto.put("support_credentials", getSupportCredentials());
        // 经营许可证
        dto.put("qualification_info_list", getQualificationInfoList());

        return dto.toJSONString();
    }

    private static String getUboInfo() {
        JSONObject dto = new JSONObject();
        // 证件姓名
        dto.put("ubo_id_doc_name", "李铁航");
        // 证件类型
        dto.put("ubo_id_doc_type", "00");
        // 证件号码
        dto.put("ubo_id_doc_number", "130827198408270012");
        // 持卡人证件有效期类型
        dto.put("cert_validity_type", "0");
        // 证件有效期开始时间
        dto.put("ubo_period_begin", "20210203");
        // 证件有效期结束时间
        dto.put("ubo_period_end", "20410203");
        // 证件正面照片
        dto.put("ubo_id_doc_copy", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 证件反面照片
        dto.put("ubo_id_doc_copy_back", "a22eef73-b024-3d1a-a089-d34837573416");

        return dto.toJSONString();
    }


    private static String getLegalPersonInfo() {
        JSONObject dto = new JSONObject();
        // 证件持有人类型
        dto.put("legal_type", "LEGAL");
        // 证件类型
        dto.put("card_type", "00");
        // 法人姓名
        dto.put("person_name", "李铁航");
        // 证件号码
        dto.put("card_no", "130827198408270012");
        // 持卡人证件有效期类型
        dto.put("cert_validity_type", "0");
        // 证件生效时间
        dto.put("effect_time", "20210203");
        // 证件过期时间
        dto.put("expire_time", "20410203");
        // 证件正面照
        dto.put("card_front_img", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 证件反面照
        dto.put("card_back_img", "a22eef73-b024-3d1a-a089-d34837573416");
        // 是否为受益人
        dto.put("is_benefit_person", "Y");

        return dto.toJSONString();
    }


    private static Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
        // 子渠道号
        extendInfoMap.put("pay_channel_id", "00004631");
        // 业务开通类型
        extendInfoMap.put("pay_scene", "1");
        // 法人身份信息
        extendInfoMap.put("legal_person_info", getLegalPersonInfo());
        // 受益人信息
        extendInfoMap.put("ubo_info", getUboInfo());
        return extendInfoMap;
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
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 设置非必填字段
       // Map<String, Object> extendInfoMap = getExtendInfos();
       // request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }
}
