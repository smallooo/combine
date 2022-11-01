package com.macro.mall;

import com.alibaba.fastjson.annotation.JSONField;
import com.huifu.bspay.sdk.opps.core.enums.FunctionCodeEnum;
import com.huifu.bspay.sdk.opps.core.request.BaseRequest;

import static com.huifu.bspay.sdk.opps.core.enums.FunctionCodeEnum.V2_MERCHANT_ACTIVITY_ADD;

public class V2MerchantActivityWebRequestDemo extends BaseRequest {


//    public enum FunctionCodeEnum {
//        V2_MERCHANT_URL_FORWARD("v2.merchant.url.forward", "商户统一进件(页面版)")
//
//        private final String code;
//        private final String name;
//
//        private FunctionCodeEnum(String code, String name) {
//            this.code = code;
//            this.name = name;
//        }
//
//        public String getCode() {
//            return this.code;
//        }
//
//        public String getName() {
//            return this.name;
//        }
//
//    }
    /**
     * 请求流水号
     */
    @JSONField(name = "req_seq_id")
    private String reqSeqId;
    /**
     * 请求日期
     */
    @JSONField(name = "req_date")
    private String reqDate;

    @JSONField(name = "upper_huifu_id")
    private String upperHuifuId;

    @JSONField(name = "phone")
    private String phone;

    @JSONField(name = "storeId")
    private String storeId;

    @JSONField(name = "expires")
    private String expires;


    @Override
    public FunctionCodeEnum getFunctionCode() {
        return V2_MERCHANT_ACTIVITY_ADD;
    }

    public void V2UserBasicdataQueryRequest() {
    }

    public void V2UserBasicdataQueryRequest( String reqSeqId, String reqDate) {
      //  this.huifuId = huifuId;
        this.reqSeqId = reqSeqId;
        this.reqDate = reqDate;
    }

    public String getReqSeqId() {
        return reqSeqId;
    }

    public void setReqSeqId(String reqSeqId) {
        this.reqSeqId = reqSeqId;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getstoreId() {
        return storeId;
    }

    public void setstoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getexpires() {
        return expires;
    }

    public void setexpires(String expires) {
        this.expires = expires;
    }

    public String getUpperHuifuId() {
        return upperHuifuId;
    }

    public void setUpperHuifuId(String upperHuifuId) {
        this.upperHuifuId = upperHuifuId;
    }

}
