package com.iamhanao.mall.controller;

import com.iamhanao.mall.common.api.CommonResult;
import com.iamhanao.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "UmsMemberController", description = "会员注册登录管理")
@Controller
@RequestMapping("sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("getAuthCode")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String phoneNum) {
        return umsMemberService.generateAuthCode(phoneNum);
    }

    @ApiOperation("校验验证码")
    @PostMapping("verifyAuthCode")
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String phoneNum,
                                       @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(phoneNum, authCode);
    }
}
