package com.macro.mall.controller.huifu;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "HfNotifyController")
@Tag(name = "HfNotifyController", description = "通知回调")
@RequestMapping("/hfnotify")
public class HfNotifyController {

}
