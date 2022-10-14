package com.macro.mall.controller.huifu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.model.UploadFileRequest;

import com.huifu.bspay.sdk.opps.client.BasePayClient;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.request.BaseRequest;
import com.huifu.bspay.sdk.opps.core.request.V2SupplementaryPictureRequest;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.service.HfShanghuService;
import com.macro.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * 用户管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfUserController")
@Tag(name = "HfUserController", description = "用户管理")
@RequestMapping("/hfuser")
public class HfUserController {

    @Autowired
    private HfShanghuService hfShanghuService;

    @Value("${HF.setRsaPublicKey}")
    private String setRsaPublicKey;

    @ApiOperation(value = "商户统一进件")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        CommonResult umsAdmin = hfShanghuService.register();
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "商户基本信息修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult statusChecking(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        CommonResult umsAdmin = hfShanghuService.register();
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "上传图片")
    @RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadphoto() throws BasePayException, IllegalAccessException, IOException {

//        public static void main(String[] args) throws Exception {
//            /**
//             * 请求流水号，需保证当天商户下唯一，推荐采用日期时间+几位流水号的形式
//             */
//            BasePay.initWithMerConfig(MerchantConfigDemo.getMerchantConfig());
//            UploadFileRequest uploadFileRequest = new UploadFileRequest(
//                    DateTools.getCurrentDateYYYYMMDD(),
//                    SequenceTools.getReqSeqId32(),
//                    "******",
//                    "F01",
//                    "法人身份证正反面.png");
//
//            Map<String, Object> result = new HashMap<>();
//            try {
//                System.out.println("文件上传请求参数：" + JSON.toJSONString(uploadFileRequest));
//                // 单商户模式可不指定merchantKey，会自动套用default配置
//                result = BasePayClient.upload(uploadFileRequest, new File("D:/文件.png"));
//                System.out.println("文件上传返回参数：" + JSON.toJSONString(result));
//            } catch (BasePayException e) {
//                e.printStackTrace();
//            }
//
//            String subRespCode = (String) result.get("sub_resp_code");
//            if ("00000000".equals(subRespCode)) {
//                // 业务处理成功
//                System.out.println("处理成功");
//            } else {
//                String subRespDesc = (String) result.get("sub_resp_desc");
//                // 业务处理失败
//                System.out.println("处理失败，失败信息：" + subRespDesc);
//            }
//        }


//        /**
//         * 请求流水号，需保证当天商户下唯一，推荐采用日期时间+几位流水号的形式
//         */
////        BasePay.initWithMerConfig(MerchantConfigDemo.getMerchantConfig());
//        UploadFileRequest uploadFileRequest = new UploadFileRequest(
//                DateTools.getCurrentDateYYYYMMDD(),
//                setRsaPublicKey,
//                "6666000122840825",
//                111,
//                111);
//
//        Map<String, Object> result = new HashMap<>();
//        try {
//            System.out.println("文件上传请求参数：" + JSON.toJSONString(uploadFileRequest));
//            // 单商户模式可不指定merchantKey，会自动套用default配置
//            result = BasePayClient.upload((BaseRequest) uploadFileRequest, new File("/1.jpeg"), "filename");
//            System.out.println("文件上传返回参数：" + JSON.toJSONString(result));
//        } catch (BasePayException e) {
//            e.printStackTrace();
//        }
//
//        String subRespCode = (String) result.get("sub_resp_code");
//        if ("00000000".equals(subRespCode)) {
//            // 业务处理成功
//            System.out.println("处理成功");
//        } else {
//            String subRespDesc = (String) result.get("sub_resp_desc");
//            // 业务处理失败
//            System.out.println("处理失败，失败信息：" + subRespDesc);
//        }

        V2SupplementaryPictureRequest request = new V2SupplementaryPictureRequest();
        // 业务请求流水号
        request.setReqSeqId("2022012614120615102");
        // 业务请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 图片类型
        request.setFileType("F01");
        // 图片名称
        request.setPicture("身份证.jpeg");


//        // 设置非必填字段
//        Map<String, Object> extendInfoMap = getExtendInfos();
//        request.setExtendInfo(extendInfoMap);

//        //因为是测试，图片url可以随便搞一个，我从百度随便复制了个图片url
//        String pictureUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0812%252Fc8eb08e2j00qxqd8w0057c0012w00obg.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651129353&t=f034e15dc07748726fa861080938ec36";
//        //建立图片连接
//        URL url = new URL(pictureUrl);
//        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//        //设置请求方式
//        connection.setRequestMethod("GET");
//        //设置超时时间
//        connection.setConnectTimeout(10*1000);
//
//        //输入流
//        InputStream stream = connection.getInputStream();
//        int len = 0;
//        byte[] test = new byte[1024];
//
//
//        //获取项目路径
          File directory = new File("mall-admin/src/main/resources/static/images");
//        String paths = directory.getCanonicalPath();
//        //如果没有文件夹则创建
//        File file = new File(paths);
//        if (!file.exists()){
//            file.mkdirs();
//        }
//
//        //设置图片名称，这个随意，我是用的当前时间命名
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
//        String date = dateFormat.format(new Date());
//        String fileName = date + ".png";
//
//        //输出流，图片输出的目的文件
//        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(directory +"/" + fileName));
//
//        //以流的方式上传
//        while ((len =stream.read(test)) !=-1){
//            fos.write(test,0,len);
//        }
//
//
//        //记得关闭流，不然消耗资源
//        stream.close();
//        fos.close();


        // 3. 发起API调用
        Map<String, Object> response = BasePayClient.upload(request, new File(directory +"/WechatIMG94.jpeg"));
        System.out.println("返回数据:" + JSONObject.toJSONString(response));

//        V2SupplementaryPictureRequest request1 = new V2SupplementaryPictureRequest();
//        // 业务请求流水号
//        request.setReqSeqId(SequenceTools.getReqSeqId32());
//        // 业务请求日期
//        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
//        // 图片类型
//        request.setFileType("F01");
//        // 图片名称
//        request.setPicture("图片名称");
//
////        // 设置非必填字段
////        Map<String, Object> extendInfoMap = getExtendInfos();
////        request.setExtendInfo(extendInfoMap);
//
//        // 3. 发起API调用
//        Map<String, Object> response1 = BasePayClient.upload(request, new File(directory +"/WechatIMG94.jpeg"));
//        System.out.println("返回数据:" + JSONObject.toJSONString(response));

        return null;
    }

}
