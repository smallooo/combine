package com.macro.mall.controller.huifu;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.HfShanghuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("商户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody List<PmsSkuStock> skuStockList) {
        CommonResult result = hfShanghuService.integrateregrequest();
        return CommonResult.success(1);
    }

    @ApiOperation(value = "查询商户信息")
    @RequestMapping(value = "/detailinfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }


    @ApiOperation(value = "商户业务开通")
    @RequestMapping(value = "/busiopen", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult busiopen(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "商户业务开通修改")
    @RequestMapping(value = "/busimodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult busimodify(@RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "图片上传")
    @RequestMapping(value = "/photoupload", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult photoupload(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态查询")
    @RequestMapping(value = "/statusquery", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusquery(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

    @ApiOperation(value = "状态变更")
    @RequestMapping(value = "/statusmodify", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult statusmodify(@RequestParam(value = "keyword", required = false) String keyword,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        CommonResult subjectList = hfShanghuService.getShanghuDetail();
        //return CommonResult.success(CommonPage.restPage(subjectList));
        return CommonResult.success(1);
    }

}
