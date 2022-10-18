package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateRegRequest;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateUpdateRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.HfShanghuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    private static String getCardInfo() {
//        JSONObject dto = new JSONObject();
//        // 结算类型 1 对私  2 对私非法人
//        dto.put("card_type", "1");
//        // 银行所在省
//        dto.put("prov_id", "310000");
//        // 银行所在市
//        dto.put("area_id", "310100");
//        // 结算账户名
//        dto.put("card_name", "何东明");
//        // 结算账号
//        dto.put("card_no", "6214835765798853");
//        // 持卡人证件有效期类型
//        dto.put("cert_validity_type", "0");
//        // 持卡人证件有效期（起始）
//        dto.put("cert_begin_date", "20170401");
//        // 持卡人证件有效期（截止）
//        dto.put("cert_end_date", "20370401");
//        // 持卡人证件号码
//        dto.put("cert_no", "331002198511211018");
//        // 持卡人证件类型
//        dto.put("cert_type", "00");
//        // 银行卡绑定手机号
//        dto.put("mp", "13567889160");

        JSONObject dto = new JSONObject();
        // 结算类型 1 对私  2 对私非法人
        dto.put("card_type", "1");
        // 银行所在省
        dto.put("prov_id", "330000");
        // 银行所在市
        dto.put("area_id", "331000");
        // 结算账户名
        dto.put("card_name", "陈盼");
        // 结算账号
        dto.put("card_no", "6230580000298182796");
        // 持卡人证件有效期类型
        dto.put("cert_validity_type", "0");
        // 持卡人证件有效期（起始）
        dto.put("cert_begin_date", "20190328");
        // 持卡人证件有效期（截止）
        dto.put("cert_end_date", "20290328");
        // 持卡人证件号码
        dto.put("cert_no", "331002199304153120");
        // 持卡人证件类型
        dto.put("cert_type", "00");
        // 银行卡绑定手机号
        dto.put("mp", "18911808760");

        return dto.toJSONString();
    }



    private static String getContactInfo() {
        JSONObject dto = new JSONObject();
//        // 联系人姓名
//        dto.put("contact_name", "何东明");
//        // 联系人手机号
//        dto.put("contact_mobile_no", "13567889160");
//        // 联系人电子邮箱
//        dto.put("contact_email", "dongming1.he@icloud.com");
//        // 联系人身份证号
//        dto.put("contact_cert_no", "331002198511211018");


        // 联系人姓名
        dto.put("contact_name", "陈盼");
        // 联系人手机号
        dto.put("contact_mobile_no", "18911808760");
        // 联系人电子邮箱
        dto.put("contact_email", "pan.chen@icloud.com");
        // 联系人身份证号
        dto.put("contact_cert_no", "331002199304153120");

        dto.put("login_name", "aaajwnfefnian");

        return dto.toJSONString();
    }

    @Autowired
    private HfShanghuService hfShanghuService;

    @ApiOperation("商户注册")
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult register() throws Exception {
        //统一进汇
        // 2.组装请求参数
        V2MerchantIntegrateRegRequest request = new V2MerchantIntegrateRegRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
//        // 渠道商汇付id
//        request.setUpperHuifuId("6666000122751000");
//        // 公司类型 0 个人商户
//        request.setEntType("0");
//        // 商户名称
//        request.setRegName("何东明");
//        // 经营类型 1 实体
//        request.setBusiType("1");
//        // 经营详细地址
//        request.setDetailAddr("深圳市宝安区新安街道海旺社区N26区海秀路2021号荣超滨海大厦A座2111");
//        // 经营省
//        request.setProvId("310000");
//        // 经营市
//        request.setAreaId("310100");
//        // 经营区
//        request.setDistrictId("310104");

                // 渠道商汇付id
        request.setUpperHuifuId("6666000122751000");
        // 公司类型 0 个人商户
        request.setEntType("0");
        // 商户名称
        request.setRegName("陈盼");
        // 经营类型 1 实体
        request.setBusiType("1");
        // 经营详细地址
        request.setDetailAddr("浙江省台州市椒江区滨海大道1688号");
        // 经营省
        request.setProvId("330000");
        // 经营市
        request.setAreaId("331000");
        // 经营区
        request.setDistrictId("331002");
        // 联系人信息
        request.setContactInfo(getContactInfo());
        // 卡信息配置实体
        request.setCardInfo(getCardInfo());

        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return CommonResult.success(1);
    }

    @ApiOperation(value = "查询商户信息")
    @RequestMapping(value = "/detailinfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
       // CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }


    @ApiOperation(value = "商户业务开通")
    @RequestMapping(value = "/busiopen", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult busiopen(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        // CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }


    private static String getAgreementInfo() {
        JSONObject dto = new JSONObject();
        // 协议类型
        dto.put("agreement_type", "test");
        // 协议号
        dto.put("agreement_no", "");
        // 协议模板号
        dto.put("agreement_model", "");
        // 协议模板名称
        dto.put("agreement_name", "");
        // 签约日期
        dto.put("sign_date", "");
        // 协议开始日期
        dto.put("agree_begin_date", "");
        // 协议结束日期
        dto.put("agree_end_date", "");

        return dto.toJSONString();
    }

    private static String getAliConfList() {
        JSONObject dto = new JSONObject();
        // 支付场景
        dto.put("pay_scene", "1");
        // 手续费（%）
        dto.put("fee_rate", "0.38");
        // 商户经营类目
        dto.put("mcc", "5309");
//        // 子渠道号
//        dto.put("pay_channel_id", "JQF00001");
//        // 拟申请的间联商户等级
//        dto.put("indirect_level", "INDIRECT_LEVEL_M3");
        // 交易手续费外扣时的账户类型
//        dto.put("out_fee_acct_type", "01");
//        // 交易手续费外扣汇付ID
//        dto.put("out_fee_huifuid", "6666000105215340");
        // 是否交易手续费外扣
        dto.put("out_fee_flag", "2");

        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }


    private static String getCashConfig() {
        JSONObject dto = new JSONObject();
        // 是否开通取现
        dto.put("switch_state", "1");
        // 业务类型
        dto.put("cash_type", "T1");
        // 取现手续费率（%）fix_amt与fee_rate至少填写一项，单位%，需保留小数点后两位，取值范围[0.00,100.00]，不收费请填写0.00；&lt;font color&#x3D;&quot;green&quot;&gt;示例值：0.05&lt;/font&gt;&lt;br/&gt;注：如果fix_amt与fee_rate都填写了则手续费&#x3D;fix_amt+支付金额*fee_rate
        dto.put("fee_rate", "0.05");
        // 提现手续费（固定/元）
        dto.put("fix_amt", "1");
        // 是否交易手续费外扣
        dto.put("out_fee_flag", "2");
        // 手续费承担方
       // dto.put("out_fee_huifu_id", "");

        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }

    private static String getSettleConfig() {
        JSONObject dto = new JSONObject();
        // 结算周期
        dto.put("settle_cycle", "T1");
        // 节假日结算手续费率
        dto.put("fixed_ratio", "");
        // 起结金额
        dto.put("min_amt", "1.00");
        // 结算手续费外扣时的账户类型
        dto.put("out_settle_acct_type", "");
        // 结算手续费外扣时的汇付ID
        dto.put("out_settle_huifuid", "6666000122994510");
        // 手续费外扣标记
        dto.put("out_settle_flag", "2");
        // 留存金额
        dto.put("remained_amt", "1000.00");
        // 结算摘要
        dto.put("settle_abstract", "结算资金");
        // 结算批次号
        dto.put("settle_batch_no", "0");
        // 结算方式
        dto.put("settle_pattern", "P1");
        // 是否优先到账
        dto.put("is_priority_receipt", "");
        // 到账时间
        dto.put("settle_time", "103000");

        return dto.toJSONString();
    }

    private static String getFileInfo() {
        JSONObject dto = new JSONObject();
//        // D1结算协议图片
//        dto.put("settle_agree_pic", "测试2022062910491030461");
//        // 授权委托书
//        dto.put("auth_enturst_pic", "0215232e-b595-368e-8a68-8c15b04f875b");
//        // 商务协议
//        dto.put("ba_pic", "d1451277-85c6-3177-ac3d-a8be47b9ae9d");
//        // 公司照片一
//        dto.put("store_header_pic", "d1451277-85c6-3177-ac3d-a8be47b9ae9d");
//        // 公司照片二
//        dto.put("store_indoor_pic", "009cd33c-01be-31f0-8e8c-615460949b96");
//        // 公司照片三
//        dto.put("store_cashier_desk_pic", "2020022204231214021970311");
        // 法人身份证反面
        dto.put("legal_cert_back_pic", "09b821a3-efc4-385d-9be2-aca353f65fb4");
        // 法人身份证正面
        dto.put("legal_cert_front_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
//        // 营业执照图片
//        dto.put("license_pic", "36ac0355-a54d-3178-b4b5-9aecd07367e6");
//        // 组织机构代码证
//        dto.put("org_code_pic", "5bd7fea7-c8e4-31fc-a672-755adbcd4a4c");
//        // 开户许可证
//        dto.put("reg_acct_pic", "d1d50615-0ff4-3488-b415-0ac21a556c4a");
        // 结算卡反面
        dto.put("settle_card_back_pic", "27f40a93-b11e-36e0-a0b4-68358c746569");
        // 结算卡正面
        dto.put("settle_card_front_pic", "c0cca9bd-64f3-362a-bfa9-f839b41634a2");
        // 结算人身份证反面
        dto.put("settle_cert_back_pic", "09b821a3-efc4-385d-9be2-aca353f65fb4");
        // 结算人身份证正面
        dto.put("settle_cert_front_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
//        // 税务登记证
//        dto.put("tax_reg_pic", "d13832f9-2244-3a3b-ba09-936b100a8ce9");
        // 实名登记证书照片
        dto.put("cert_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
        // 个人商户身份证件正面照片
        dto.put("identification_front_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
        // 个人商户身份证件反面照片
        dto.put("identification_back_pic", "09b821a3-efc4-385d-9be2-aca353f65fb4");
//        // 单位证明函照片
//        dto.put("company_prove_pic", "36ac0355-a54d-3178-b4b5-9aecd07367e6");
//        // 金融机构许可证图片1
//        dto.put("finance_license_pic1", "ff647802-0ba1-36c0-952e-e94623cf0e7c");
//        // 金融机构许可证图片2
//        dto.put("finance_license_pic2", "42cecea7-1aef-33fb-bf04-c2bc621b0302");
//        // 金融机构许可证图片3
//        dto.put("finance_license_pic3", "48157e9b-44cc-33e1-8169-a0fe8c1c0848");
//        // 金融机构许可证图片4
//        dto.put("finance_license_pic4", "ca1cbd42-b14e-326b-9aef-288d45cf8b42");
//        // 金融机构许可证图片5
//        dto.put("finance_license_pic5", "2e74d95f-fd16-3766-ab39-c407c5b1c004");
        // 联系人身份证正面照
        dto.put("contact_id_front_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
        // 联系人身份证反面照
        dto.put("contact_id_back_pic", "09b821a3-efc4-385d-9be2-aca353f65fb4");
//        // 联系人护照人像面
//        dto.put("contact_passport_img_pic", "8958a61c-970c-3ad8-a091-80238ef80a8b");
//        // 联系人证件照正面
//        dto.put("contact_cert_front_pic", "75ef9587-2faf-3b2c-820b-9ea447e754e3");
//        // 联系人证件照反面
//        dto.put("contact_cert_back_pic", "d42c010b-9316-369f-80ed-4ce4bda13602");
//        // 微信业务办理授权函
//        dto.put("contact_wx_busi_auth_pic", "49ac7d9b-851c-31b4-8b21-2983ea97b98c");
//        // 行业经营许可证资质照片一
//        dto.put("industry_busi_license_pic1", "1931c359-e42f-3e5f-875e-e22fc695aefd");
//        // 行业经营许可证资质照片二
//        dto.put("industry_busi_license_pic2", "0ddea6a0-6991-39ac-a68d-155d5d00d840");
//        // 行业经营许可证资质照片三
//        dto.put("industry_busi_license_pic3", "b5d77b0f-391f-3447-9843-386fc4096649");
//        // 行业经营许可证资质照片四
//        dto.put("industry_busi_license_pic4", "2af4514d-3d9c-3545-bc45-2424e80ab7e4");
//        // 行业经营许可证资质照片五
//        dto.put("industry_busi_license_pic5", "c3421d61-df60-3b2d-bcf1-e3709da867f2");
//        // 行业经营许可证资质照片六
//        dto.put("industry_busi_license_pic6", "b56c5cb1-4724-3574-ae38-7e8d5510b607");
//        // 法人护照人像面
//        dto.put("legal_passport_img_pic", "893dd8c7-c0a6-3cbd-a6c2-a52baf40398c");
//        // 法人港澳台通行证正面
//        dto.put("legal_hk_aom_front_pic", "8cb60559-e51c-344e-bcbf-96f3011acbd4");
//        // 法人其他证件照片
//        dto.put("legal_other_cert_pic", "562511a9-aa29-3e9e-9647-a97430ea9766");
        // 持卡人身份证人像面
        dto.put("cert_front_pic", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
        // 持卡人身份证国徽面
        dto.put("cert_back_pic", "09b821a3-efc4-385d-9be2-aca353f65fb4");
//        // 持卡人护照人像面
//        dto.put("cert_passport_img_pic", "a501f0c6-a9ee-30d0-aedb-cec882da6d21");
//        // 持卡人港澳台通行证正面
//        dto.put("cert_hk_aom_front_pic", "cdcae795-6a9d-32f8-8033-d7bad4008974");
//        // 持卡人其它证件照片
//        dto.put("cert_other_pic", "398bbd13-40c9-37ce-8265-f6c1ecd317fa");
        // 签约人身份证照片-人像面
        dto.put("sign_identity_front_file_id", "11789b79-a6b5-38ed-a61f-59593cc4a7cf");
//        // 签约人身份证照片-国徽面
        dto.put("sign_identity_back_file_id", "09b821a3-efc4-385d-9be2-aca353f65fb4");
//        // 签约人法人授权书
//        dto.put("sign_auth_file_id", "");
//        // 支付宝授权函照片
//        dto.put("contact_ali_busi_auth_pic", "");

        return dto.toJSONString();
    }



    private static Map<String, Object> getExtendInfos() {
        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
//        // 商户基本信息
//        extendInfoMap.put("basic_info", getBasicInfo());
        // 卡信息配置实体
        extendInfoMap.put("card_info", getCardInfo());
//        // 协议信息实体
//        extendInfoMap.put("agreement_info", getAgreementInfo());
//        // 支付补贴
//        extendInfoMap.put("combine_pay_config", getCombinePayConfig());
        // 取现配置列表
        extendInfoMap.put("cash_config", getCashConfig());
//        // 结算配置实体
//        extendInfoMap.put("settle_config", getSettleConfig());
//        // 业务开关对象
//        extendInfoMap.put("biz_conf", getBizConf());
//        // 微信配置对象
//        extendInfoMap.put("wx_conf_list", getWxConfList());
//        // 实名认证信息
//        extendInfoMap.put("wx_realname_info", getWxRealnameInfo());
        // 支付宝配置对象
        extendInfoMap.put("ali_conf_list", getAliConfList());
//        // 银联小微入驻信息实体
//        extendInfoMap.put("union_micro_info", getUnionMicroInfo());
//        // 银联配置对象
//        extendInfoMap.put("union_conf_list", getUnionConfList());
//        // 银行卡业务配置实体
//        extendInfoMap.put("bank_card_conf", getBankCardConf());
//        // 余额支付配置实体
//        extendInfoMap.put("balance_pay_config", getBalancePayConfig());
//        // 花呗分期费率配置实体
//        extendInfoMap.put("hb_fq_fee_config", getHbFqFeeConfig());
        // 文件列表
        extendInfoMap.put("file_info", getFileInfo());
        // 异步消息接收地址(审核)
        extendInfoMap.put("async_return_url", "");
        // 业务开通结果异步消息接收地址
        extendInfoMap.put("busi_async_return_url", "");
        // 交易异步应答地址
        extendInfoMap.put("recon_resp_addr", "");
//        // 线上费率配置
//        extendInfoMap.put("online_fee_conf_list", getOnlineFeeConfList());
//        // 线上手续费承担方配置
//        extendInfoMap.put("online_pay_fee_conf_list", getOnlinePayFeeConfList());
        // 商户业务类型
        extendInfoMap.put("mer_bus_type", "");
        return extendInfoMap;
    }



    @ApiOperation(value = "商户业务开通修改")
    @RequestMapping(value = "/busimodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult busimodify() throws Exception {
       // CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));

        // 2.组装请求参数
        V2MerchantIntegrateUpdateRequest request = new V2MerchantIntegrateUpdateRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 汇付ID
        request.setHuifuId("6666000122994510");
        // 渠道商汇付ID
        request.setUpperHuifuId("6666000123121915");
        // 业务处理类型
        request.setDealType("1");

        // 设置非必填字段
        Map<String, Object> extendInfoMap = getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));


        return CommonResult.success(1);
    }

    @ApiOperation(value = "图片上传")
    @RequestMapping(value = "/photoupload", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult photoupload(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
       // CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态查询")
    @RequestMapping(value = "/statusquery", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusquery(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
       // CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态变更")
    @RequestMapping(value = "/statusmodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusmodify(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
      //  CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

}
