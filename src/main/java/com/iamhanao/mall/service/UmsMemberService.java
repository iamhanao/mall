package com.iamhanao.mall.service;

import com.iamhanao.mall.common.api.CommonResult;

public interface UmsMemberService {
    CommonResult generateAuthCode(String phoneNum);
    CommonResult verifyAuthCode(String phoneNum, String authCode);
}
