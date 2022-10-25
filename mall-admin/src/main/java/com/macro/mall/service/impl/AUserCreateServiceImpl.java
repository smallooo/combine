package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.request.V2MerchantIntegrateRegRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.controller.huifu.BaseCommonDemo;
import com.macro.mall.dao.OmsOrderDao;
import com.macro.mall.dto.huifu.HFUserParam;

import com.macro.mall.mapper.AddresstoidMapper;
import com.macro.mall.model.Addresstoid;
import com.macro.mall.model.AddresstoidExample;
import com.macro.mall.service.AUserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AUserCreateServiceImpl implements AUserCreateService {

    @Autowired
    private AddresstoidMapper addresstoidMapper;

    @Override
    public CommonResult createUser(HFUserParam user) throws Exception {
        V2MerchantIntegrateRegRequest request = new V2MerchantIntegrateRegRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32()); // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        request.setUpperHuifuId("6666000122751000"); // 渠道商汇付id
        request.setEntType("0"); // 公司类型 0 个人商户
        request.setRegName(user.getIdname()); // 商户名称
        request.setBusiType("1");  // 经营类型 1 实体

        AddresstoidExample addresstoidExample = new AddresstoidExample(); // 经营详细地址
        List<Addresstoid> addressList = addresstoidMapper.selectByExampleWithBLOBs(addresstoidExample);
        for (Addresstoid addresstoid : addressList) {
            if(Objects.equals(addresstoid.getProvicename(), user.getProv()) && Objects.equals(addresstoid.getCityname(), user.getArea()) && Objects.equals(addresstoid.getQuname(), user.getDistrict())){
                request.setProvId(addresstoid.getProviceid().toString()); // 经营省
                request.setAreaId(addresstoid.getCityid()); // 经营市
                request.setDistrictId(addresstoid.getQuid().toString()); // 经营区
            }
        }
        request.setDetailAddr(user.getDetailaddr()); // 经营详细地址

        JSONObject dto = new JSONObject();
        dto.put("contact_name", user.getCard_name());
        dto.put("contact_mobile_no", user.getMobileno());
        dto.put("contact_email", user.getEmail());
        dto.put("contact_cert_no", user.getIdno());
        request.setContactInfo(dto.toJSONString());

        JSONObject dto1 = new JSONObject();
        dto1.put("card_type", "1"); // 结算类型 1 对私  2 对私非法人
        for (Addresstoid addresstoid : addressList) {
            if(Objects.equals(addresstoid.getProvicename(), user.getCard_prov()) && Objects.equals(addresstoid.getCityname(), user.getCard_area())){
                dto1.put("prov_id", addresstoid.getProviceid().toString()); // 银行所在省
                dto1.put("area_id", addresstoid.getCityid()); // 银行所在市
            }
        }

        dto1.put("card_name", user.getCard_name()); // 结算账户名
        dto1.put("card_no", user.getCard_no()); // 结算账号

        dto1.put("cert_validity_type", "0"); // 持卡人证件有效期类型
        dto1.put("cert_begin_date", "20210203"); // 持卡人证件有效期（起始）
        dto1.put("cert_end_date", "20410203"); // 持卡人证件有效期（截止）

        dto1.put("cert_no", user.getIdno());  // 持卡人证件号码
        dto1.put("cert_type", "00"); // 持卡人证件类型
        dto1.put("mp", user.getCard_phone_no()); // 银行卡绑定手机号
        request.setCardInfo(dto1.toJSONString());


        Map<String, Object> extendInfoMap = new HashMap<>();
        extendInfoMap.put("cash_config", getUserCashConfig()); //取现配置列表
        extendInfoMap.put("settle_config", getUserSettleConfig()); //结算配置实体
        extendInfoMap.put("biz_conf", getUserBizConf()); // 业务开关对象
        extendInfoMap.put("wx_realname_info", getUserWxRealnameInfo()); // 实名认证信息
        extendInfoMap.put("ali_conf_list", getUserAliConfList());  // 支付宝配置对象
        //extendInfoMap.put("login_name", "15900777754"); // 管理员账号
        extendInfoMap.put("file_info", getUserFileInfo());
        extendInfoMap.put("async_return_url", "http://101.34.88.176:8080/hfcallback/asyncreturn"); // 异步消息接收地址(审核)
        extendInfoMap.put("busi_async_return_url", "http://101.34.88.176:8080/hfcallback/busiasyncreturn"); // 业务开通结果异步消息接收地址
        extendInfoMap.put("recon_resp_addr", "http://101.34.88.176:8080/hfcallback/asyncMessageHand"); // 交易异步应答地址
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        Map<String, Object> response = BaseCommonDemo.doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

    private static String getUserCashConfig() {
        JSONObject dto = new JSONObject();
        // 是否开通取现
        dto.put("switch_state", "1");
        // 业务类型
        dto.put("cash_type", "T1");
        // 取现手续费率（%）fix_amt与fee_rate至少填写一项，单位%，需保留小数点后两位，取值范围[0.00,100.00]，不收费请填写0.00；&lt;font color&#x3D;&quot;green&quot;&gt;示例值：0.05&lt;/font&gt;&lt;br/&gt;注：如果fix_amt与fee_rate都填写了则手续费&#x3D;fix_amt+支付金额*fee_rate
        dto.put("fee_rate", "0.05");
        // 提现手续费（固定/元）
        dto.put("fix_amt", "0.01");
        // 是否交易手续费外扣
        dto.put("out_fee_flag", "2");
        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }

    private static String getUserSettleConfig() {
        JSONObject dto = new JSONObject();
        // 结算周期
        dto.put("settle_cycle", "T1");
        // 节假日结算手续费率
        dto.put("fixed_ratio", "0.38");
        // 起结金额
        dto.put("min_amt", "1.00");
        // 手续费外扣标记
        dto.put("out_settle_flag", "2");
        // 留存金额
        dto.put("remained_amt", "1.00");
        // 结算摘要
        dto.put("settle_abstract", "结算资金");
        // 结算批次号
        dto.put("settle_batch_no", "0");
        // 结算方式
        dto.put("settle_pattern", "P0");
        return dto.toJSONString();
    }

    private static String getUserBizConf() {
        JSONObject dto = new JSONObject();
        // 是否开通结算
        dto.put("settle_flag", "Y");
        return dto.toJSONString();
    }

    private static String getUserWxRealnameInfo() {
        JSONObject dto = new JSONObject();
        // 支付场景
        dto.put("pay_scene", "1");
        // 联系人证件号码
        dto.put("contact_id_card_number", "130827198408270012");
        // 实名认证类型
        dto.put("realname_info_type", "A");
        // 子渠道号
        dto.put("pay_channel_id", "00004631");
        // 联系人姓名
        dto.put("name", "李铁航");
        // 联系人手机号
        dto.put("mobile", "15900777754");
        // 联系人类型
        dto.put("contact_type", "LEGAL");
        // 联系人证件类型
        dto.put("contact_id_doc_type", "00");
        // 联系人证件有效期开始时间
        dto.put("contact_period_begin_date", "20210203");
        // 联系人证件有效期结束时间
        dto.put("contact_period_end_date", "20410203");
        dto.put("finance_institution_flag", "N");
        return dto.toJSONString();
    }

    private static String getUserAliConfList() {
        JSONObject dto = new JSONObject();
        // 支付场景
        dto.put("pay_scene", "1");
        // 手续费（%）
        dto.put("fee_rate", "0.38");
        // 商户经营类目
        dto.put("mcc", "5021");
        // 是否交易手续费外扣
        dto.put("out_fee_flag", "2");
        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList.toJSONString();
    }

    private static String getUserFileInfo() {
        JSONObject dto = new JSONObject();
        // 法人身份证反面
        dto.put("legal_cert_back_pic", "9b73a96e-12b6-37b9-916a-59a611713b80");
        // 法人身份证正面
        dto.put("legal_cert_front_pic", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 结算卡反面
        dto.put("settle_card_back_pic", "ce6c8b31-a2ae-3a03-8d55-d626cc967385");
        // 结算卡正面
        dto.put("settle_card_front_pic", "0681f121-aec4-3946-9157-73e42d936b6f");
        // 结算人身份证反面
        dto.put("settle_cert_back_pic", "a22eef73-b024-3d1a-a089-d34837573416");
        // 结算人身份证正面
        dto.put("settle_cert_front_pic", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 个人商户身份证件正面照片
        dto.put("identification_front_pic", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 个人商户身份证件反面照片
        dto.put("identification_back_pic", "a22eef73-b024-3d1a-a089-d34837573416");
        // 联系人身份证正面照
        dto.put("contact_id_front_pic", "856ec6fa-5632-3646-8e9f-4ee52cd0a7b1");
        // 联系人身份证反面照
        dto.put("contact_id_back_pic", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 持卡人身份证人像面
        dto.put("cert_front_pic", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
        // 持卡人身份证国徽面
        dto.put("cert_back_pic", "a22eef73-b024-3d1a-a089-d34837573416");
        // 签约人身份证照片-人像面
        dto.put("sign_identity_front_file_id", "31ba476c-d6f7-3ec1-ad20-2cf4ce3ea5eb");
//        // 签约人身份证照片-国徽面
        dto.put("sign_identity_back_file_id", "a22eef73-b024-3d1a-a089-d34837573416");
        return dto.toJSONString();
    }
}
