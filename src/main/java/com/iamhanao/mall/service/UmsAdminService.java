package com.iamhanao.mall.service;

import com.iamhanao.mall.mbg.model.UmsAdmin;
import com.iamhanao.mall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和额外分配给用户的权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 后台用户注册
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 后台用户登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);
}
