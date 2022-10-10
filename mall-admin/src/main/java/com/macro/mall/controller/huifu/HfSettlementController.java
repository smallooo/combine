package com.macro.mall.controller.huifu;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 提现管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfSettlemenController")
@Tag(name = "HfSettlemenController", description = "提现管理")
@RequestMapping("/hfsettlemen")
public class HfSettlementController {
}
