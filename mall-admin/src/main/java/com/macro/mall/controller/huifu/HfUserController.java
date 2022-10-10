package com.macro.mall.controller.huifu;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "HfUserController")
@Tag(name = "HfUserController", description = "用户管理")
@RequestMapping("/hfuser")
public class HfUserController {
}
