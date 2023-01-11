package com.lsc.service;

import com.lsc.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PermissionService
 * @Description
 * @Date 2023/1/9 18:58
 * @Created by linmour
 */

@Service("ps")
public class PermissionService {

    /**
     * 判断当前用户是否具有permission
     * @param permission 要判断的权限
     * @return
     */
    public boolean hasPermission(String permission){
        //如果是超级管理员  直接返回true
        if(SecurityUtils.isAdmin()){
            return true;
        }
        //否则  获取当前登录用户所具有的权限列表 如何判断是否存在permission
        List<String> permissions = SecurityUtils.getLoginUser().getPermissions();
        return permissions.contains(permission);
    }
}