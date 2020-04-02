package com.iamhanao.mall.service.impl;

import com.iamhanao.mall.common.api.CommonResult;
import com.iamhanao.mall.service.RedisService;
import com.iamhanao.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTH_CODE;

    @Override
    public CommonResult generateAuthCode(String phoneNum) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i=0; i<6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum, REDIS_KEY_EXPIRE_AUTH_CODE);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String phoneNum, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String code = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum);
        if (authCode.equals(code)) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
