package com.macro.mall;

import com.alibaba.fastjson.annotation.JSONField;
import com.huifu.bspay.sdk.opps.core.enums.FunctionCodeEnum;
import com.huifu.bspay.sdk.opps.core.request.BaseRequest;

public class V2MerchantActivityWebRequestDemo extends BaseRequest {

    /**
     * 汇付客户Id
     */
//    @JSONField(name = "huifu_id")
//    private String huifuId;
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
        return FunctionCodeEnum.V2_USER_BASICDATA_QUERY;
    }

    public void V2UserBasicdataQueryRequest() {
    }

    public void V2UserBasicdataQueryRequest( String reqSeqId, String reqDate) {
      //  this.huifuId = huifuId;
        this.reqSeqId = reqSeqId;
        this.reqDate = reqDate;
    }

//    public String getHuifuId() {
//        return huifuId;
//    }
//
//    public void setHuifuId(String huifuId) {
//        this.huifuId = huifuId;
//    }

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
