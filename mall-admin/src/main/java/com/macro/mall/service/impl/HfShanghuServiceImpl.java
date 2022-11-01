package com.macro.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.config.MerConfig;
import com.huifu.bspay.sdk.opps.core.request.*;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.V2MerchantActivityWebRequestDemo;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.controller.huifu.BaseCommonDemoLocal;
import com.macro.mall.dto.huifu.HFUserParam;
import com.macro.mall.dto.huifu.MerchantForwardParam;
import com.macro.mall.dto.huifu.MerchantForwardResult;
import com.macro.mall.mapper.AddresstoidMapper;
import com.macro.mall.service.HfShanghuService;
import com.macro.mall.util.HFUserCreateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

import static com.macro.mall.controller.huifu.BaseCommonDemo.doExecute;
import static com.macro.mall.controller.huifu.BaseCommonDemo.doInit;
import static com.macro.mall.util.HFUserModifyUtil.*;

@Service
public class HfShanghuServiceImpl implements HfShanghuService {
    @Autowired
    private AddresstoidMapper addresstoidMapper;

    //进行商户统一进件
    @Override
    public CommonResult interateRegRequest(HFUserParam hFUserParam) throws Exception {

        HFUserCreateUtil.extracted(hFUserParam,addresstoidMapper);

        return null;
    }

    // 生成统一进件网页版
    @Override
    public MerchantForwardResult interateRegByWebRequest(MerchantForwardParam merchantForwardParam) throws Exception {
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

        BaseCommonDemoLocal.doInit(merConfig);

        V2MerchantActivityWebRequestDemo request = new V2MerchantActivityWebRequestDemo();
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        request.setUpperHuifuId("6666000122751000");
        request.setphone(merchantForwardParam.getPhone());
        request.setstoreId(merchantForwardParam.getPhone());
        request.setexpires("50000");

        Map<String, Object> response = BaseCommonDemoLocal.doExecute(request);

        JSONObject result = JSONObject.parseObject(String.valueOf(response)) ;
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        MerchantForwardResult returnresult = new MerchantForwardResult();

//        returnresult.setResp_desc((String) result.get("resp_desc"));
//        returnresult.setResp_code((String) result.get("resp_code"));
//        returnresult.setResp_desc((String) result.get("req_seq_id"));

        returnresult.setResp_desc( result.getString("resp_desc"));
        returnresult.setReq_seq_id( result.getString("req_seq_id"));
        returnresult.setProduct_id( result.getString("product_id"));
        returnresult.setRep_date( result.getString("req_date"));
        returnresult.setResp_code( result.getString("resp_code"));
        returnresult.setUrl( result.getString("url"));

        return returnresult;
    }


    //商户统一变更接口
    @Override
    public CommonResult integrateUpdateRequest() throws Exception {
        V2MerchantIntegrateUpdateRequest request = new V2MerchantIntegrateUpdateRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32()); // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD()); // 请求日期
        request.setHuifuId("6666000123196564"); // 汇付ID
        request.setUpperHuifuId("6666000122751000"); // 渠道商汇付ID
        request.setDealType("2"); // 业务处理类型
        Map<String, Object> extendInfoMap = getExtendInfos();  // 设置非必填字段
        request.setExtendInfo(extendInfoMap);
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }


    //获取当前商户详细信息
    @Override
    public CommonResult getShanghuDetail() throws Exception {
        V2MerchantBasicdataQueryRequest request = new V2MerchantBasicdataQueryRequest();
        request.setReqSeqId(SequenceTools.getReqSeqId32()); // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD()); // 请求日期
        request.setHuifuId("6666000123196564"); // 汇付客户Id
        Map<String, Object> extendInfoMap = getExtendInfos(); // 设置非必填字段
        request.setExtendInfo(extendInfoMap);
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

    @Override
    public CommonResult setSplit() throws Exception {
        V2MerchantSplitConfigRequest request = new V2MerchantSplitConfigRequest();  // 2.组装请求参数
        request.setReqSeqId(SequenceTools.getReqSeqId32());  // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());  // 请求时间
        request.setProductId("ZDTEST");  // 产品编号
        request.setHuifuId("6666000003113429");
        request.setRuleOrigin("01"); // 分账规则来源
        request.setRepealFlag("Y"); // 分账是否支持撤销交易
        request.setRefundFlag("Y"); // 分账是否支持退货交易
        request.setDivFlag("Y");  // 分账开关
        request.setApplyRatio("90"); // 最大分账比例
        request.setStartType("0");  // 生效类型
//        // 设置非必填字段
//        Map<String, Object> extendInfoMap = getExtendInfos();
//        request.setExtendInfo(extendInfoMap);
        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

    @Override
    public CommonResult checkSplit() throws Exception {
        V2MerchantSplitQueryRequest request = new V2MerchantSplitQueryRequest();  // 2.组装请求参数
        request.setReqSeqId(SequenceTools.getReqSeqId32());  // 请求流水号
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());  // 请求时间
        request.setProductId("ZDTEST");  // 产品编号
        request.setHuifuId("6666000003113429");  // 汇付客户Id
//        Map<String, Object> extendInfoMap = getExtendInfos();   // 设置非必填字段
//        request.setExtendInfo(extendInfoMap);
        Map<String, Object> response = doExecute(request);      // 3. 发起API调用
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return null;
    }

    @Override
    public CommonResult alirealnamequery() throws Exception {
        V2MerchantBusiAliRealnameQueryRequest request = new V2MerchantBusiAliRealnameQueryRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求时间
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 商家汇付ID
        request.setHuifuId("");

        // 3. 发起API调用
        Map<String, Object> response = doExecute(request);
        System.out.println("返回数据:" + JSONObject.toJSONString(response));
        return null;
    }

}
