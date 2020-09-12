package com.gdpi.ssm.dao;

import com.gdpi.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    public List<Role> findByUserId(String userId) throws Exception;
}
