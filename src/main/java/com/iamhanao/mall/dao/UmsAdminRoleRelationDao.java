package com.iamhanao.mall.dao;

import com.iamhanao.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义 Dao
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 根据用户 ID 获取用户所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
