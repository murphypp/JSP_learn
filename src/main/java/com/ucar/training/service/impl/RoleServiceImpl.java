package com.ucar.training.service.impl;

import com.ucar.training.entity.Role;
import com.ucar.training.mapper.RoleMapper;
import com.ucar.training.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public Role getRoleById(int rid) {
        return roleMapper.getRoleById(rid);
    }

    @Override
    public Role getRoleByUsername(String username) {
        return roleMapper.getUserRoleByUsername(username);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void delRole(Role role) {
        roleMapper.delRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public void close() {

    }

    @Override
    public void delRolePermissions(int rid) {
        roleMapper.delRolePermissionsById(rid);
    }

    @Override
    public void addRolePermission(int rid, String[] permissions) {
        for (String x:permissions){
            roleMapper.addRolePermission(rid,Integer.parseInt(x));
        }
    }
}
