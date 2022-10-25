package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.config.MerConfig;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameApplyRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantBusiAliRealnameQueryRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.V2MerchantActivityWebRequestDemo;
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

import static com.macro.mall.BaseCommonDemo.doInit;
import static com.macro.mall.config.HfConfig.initMerchantConfig;
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
        System.out.println("返回数据:" + hfUserParam.getUsername() + hfUserParam.getPassword() + hfUserParam.getMobileno());
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

//    @ApiOperation(value = "图片上传")
//    @RequestMapping(value = "/photoupload", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult photoupload() {
//        //上传汇付
//        //上传阿里云
//        return CommonResult.success(1);
//    }

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
        dto.put("store_door_img", "1ace0d4e-467d-3010-a543-6c8fa4183803");
        // 门店店内照片或者摊位照侧面
        dto.put("store_inner_img", "1ace0d4e-467d-3010-a543-6c8fa4183803");

        return dto.toJSONString();
    }

    private static String getQualificationInfoList() {
        JSONObject dto = new JSONObject();
        // 行业类目id
        dto.put("mcc_code", "5331");
        // 行业经营许可证资质照片
        dto.put("image_list", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb,31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");

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

    @ApiOperation("统一进件网页版")
    @RequestMapping(value = "/registerfromweb", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult registerfromweb() throws Exception {
        BasePay.debug = true;
        BasePay.prodMode = BasePay.MODE_PROD;
        MerConfig merConfig = new MerConfig();
        merConfig.setProcutId("EDUSTD");      //汇付分配产品号
        merConfig.setSysId("6666000122751000");         //汇付分配系统号  渠道号
        merConfig.setRsaPrivateKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC53vb85DPQPKI9tvazG2f3O6qt2Dm5tGoEaPwKucOxJnD/ztVe5z+jU2+8GMFEyD1SwFDMISWp2P24/E5XWMVOPCb7ArtBxeet3QWu1uzOTZSIKrt0013dsmc4df/SwWSZVU8DaHmL0x5hY60QUmzul3D+jC8akC4D92DqWwFivCORjvNz0sTbo0ExsNsQEtZdsIg+SjBvPbDvxdN3Z89ZdGt8R3V6IYll6gEzMyvYD3T5NtzEjCnAzrA8MtEiRtqAJ99VhHI08cMP5qEKA3bjRJArxuplNgWEFyBMuAJHSJQTSvY9zM/VO38BjYDB60WZxo5RO5TtsDJRiDDjtkCtAgMBAAECggEAVwSVqUvFHiZk5nO0B6I7CDo86+qhC9n1EF9+MB9MCLGwkXJp3mZxGqvDUdJdGTCN1SIIMakLEvttvZ8Rpj7/EGOE9FsRA/f9QR6KvJIOh382nJE09brG5TXSsVI9FJRJ3qdbuIK+9MFAJeQeb9fG++SWl/VVUCBUCrNUAiPdADW8KD9Kx3ufCu6vkFPZTRMuq/U43Kvp2SLE59OG4lPywvTbhbJRTWrNUk3xv+S3RRSLXYKJz0ysE/F/XYh9DjWtPLgbyZSxzB51r4vdlQKaoULIanir8fWIAGlDtvvdcsTm4wnmI6rSCc0YMTEX+o17kWqzG6q7TZupUPD33a9UAQKBgQDiDtjmWAExmmAoXS923i+tl3MdMBkBeXoYrJOnc5Dkru4w5HOo38YseOKTJcqg/TgiRIxX4qu5W+9pN5QxgOYVjXPhp+gqn0dxiSsdyS80+SRmImHUlbDSc40/xXZjTvr1KkwkdnBMqz3mdK6GgjddXyU34LYJQCfim6+dwl3dgQKBgQDSfXWQGPp89MDIGuoB2U6caGy8jqC715rcV3vwyv7fqWBHJ2xHjqiAk9Ml6hxfL5Sv2pSY/eyPKQj31AK+FDKAAm2Q9oNnbxUEzEn2fQ1UwXJm5ssB/14AVe43gCJlOf+LL60gEAKJbuqbFZiY7nCoAj3X8lmqpYxCMEdFh2DRLQKBgHTPqUL1zMAd/nw9Es7ApzBzZxd5CCLb67yeSLopnICe6BQ5qI5l+5h1atcQmzEvR/dlJoQva/8fQ4pCHwCpk7slWfEL+4syvQ8tCyucDxm3eBiSwazBIRrOfPmsBq3wXPucvLXGwebMQfM47goxdXx5Mtk587a6ASI2wrupeSmBAoGAbpQEN9A3f3+g6z7gYlpD5v0g6qnPHP92Vn0LGoO6A8vaTWcThkAWm32NNmTXxNWdOgkNeZYkOU0obfGOA0dfBErCPp6Sh7segqfDz18Aqt75d7+VNJZwTqLWA4goCZ+/dOJ2A9sFSiffzds5kFXrDwgmbxTdMD3KAleUiZ1GKn0CgYAvsRnUeNf1qYUW2oM6vIGyclxkakBW5Ard61x/jvpMwLfiQ+z/upQKr4UBXfOI3FzVSlAGO/yFhJmJ/KKF4gb2KeQTbhfZxCUx6LIuGC8w14a5uOfSo8Z3uPWoyoR5kioKpeKNMH1CkwSd4gQfFXTkA2VY38RxYPmRLYpiaxnX+g==");  //汇付分配私钥
        merConfig.setRsaPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt5hd0XSAusIkRYMEXv6ZHlCU9XIQsgJWmnarxJamVQ/4hjCeefUoD/PX7cH+pmw6IMhDYLSrbM8Jdcfz4cxZl1cOLEchpYEkRehr6hER1/bJqWTLDDEWzPSWqcwpQLCW70XueJh2LHu/u2EillRUf8RT4aiO4zobujlUhblSgAYI7M8/wH2ehva8rlAQ2go8evhZcWW1WafW5IjmXbYqAyXF/swukG4tTFAXrtwdUVZAT4jJphVfdO0UbxMng4Kv9S/K9Hh+H1mtwb2SKJwAmfTWMt9YVJFk00jPhFJsxqliGxY0TMjb9wC2Y8A1eElZWP4VcWQoKe+Sx1kg37KolQIDAQAB");
        try {
            BasePay.initWithMerConfig(merConfig);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        doInit(merConfig);

        V2MerchantActivityWebRequestDemo request = new V2MerchantActivityWebRequestDemo();
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求时间
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID

        request.setUpperHuifuId("6666000122751000");
        request.setphone("13567889160");
        request.setstoreId("SH001");
        request.setexpires("50000");


        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }

}
