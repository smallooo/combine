package com.macro.mall.controller.huifu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huifu.bspay.sdk.opps.core.BasePay;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.exception.FailureCode;
import com.huifu.bspay.sdk.opps.core.net.BasePayRequest;
import com.huifu.bspay.sdk.opps.core.request.BaseRequest;
import com.huifu.bspay.sdk.opps.core.utils.ObjectUtils;
import com.huifu.bspay.sdk.opps.core.utils.StringUtil;

import java.io.File;
import java.util.Map;

public class BasePayClient {
    public BasePayClient() {
    }

    public static Map<String, Object> request(BaseRequest request) throws BasePayException, IllegalAccessException {
        return request(request, request.getFunctionCode().getCode(), false);
    }

    public static Map<String, Object> request(BaseRequest request, boolean isPage) throws BasePayException, IllegalAccessException {
        return request(request, "v2.merchant.url.forward", isPage);
    }

    public static Map<String, Object> request(BaseRequest request, String funcCode, boolean isPage) throws BasePayException, IllegalAccessException {
        return request((BaseRequest)request, funcCode, (String)null, isPage);
    }

    public static Map<String, Object> request(BaseRequest request, String funcCode, String merchantKey, boolean isPage) throws BasePayException, IllegalAccessException {
        Map<String, Object> params = ObjectUtils.objectToMap(request);
        if (request.getExtendInfos() != null && request.getExtendInfos().size() > 0) {
            params.putAll(request.getExtendInfos());
        }

        return request(params, funcCode, merchantKey, isPage);
    }

    public static Map<String, Object> request(Map<String, Object> params, String funcCode, boolean isPage) throws BasePayException {
        return request((Map)params, funcCode, (String)null, isPage);
    }

    public static Map<String, Object> request(Map<String, Object> params, String funcCode, String merchantKey, boolean isPage) throws BasePayException {
        if (StringUtil.isEmpty(funcCode)) {
            throw new BasePayException(FailureCode.REQUEST_PARAMETER_ERROR.getFailureCode(), "请指定要调用的接口的功能编码");
        } else {
            if (params.containsKey("risk_check_data")) {
                Object riskCheckInfo = params.get("risk_check_data");
                if (!(riskCheckInfo instanceof String)) {
                    params.put("risk_check_data", JSON.toJSONString(riskCheckInfo));
                }
            }

            String interfaceUrl = funcCode.replaceAll("\\.", "/");
            return BasePayRequest.requestBasePay(interfaceUrl, params, merchantKey, isPage);
        }
    }

    public static Map<String, Object> upload(BaseRequest request, File file) throws BasePayException, IllegalAccessException {
        Map<String, Object> params = ObjectUtils.objectToMap(request);
        if (request.getExtendInfos() != null && request.getExtendInfos().size() > 0) {
            params.putAll(request.getExtendInfos());
        }

        if (BasePay.debug) {
            System.out.println(">>" + JSONObject.toJSONString(params));
        }

        return upload(params, file, request.getFunctionCode().getCode(), (String)null);
    }

    public static Map<String, Object> upload(Map<String, Object> params, File file, String funcCode) throws BasePayException {
        return upload(params, file, funcCode, (String)null);
    }

    public static Map<String, Object> upload(Map<String, Object> params, File file, String funcCode, String merchantKey) throws BasePayException {
        if (StringUtil.isEmpty(funcCode)) {
            throw new BasePayException(FailureCode.REQUEST_PARAMETER_ERROR.getFailureCode(), "请指定要调用的接口的功能编码");
        } else {
            String interfaceUrl = funcCode.replaceAll("\\.", "/");
            return BasePayRequest.requestBasePay(interfaceUrl, params, file, "file", merchantKey, true);
        }
    }
}
