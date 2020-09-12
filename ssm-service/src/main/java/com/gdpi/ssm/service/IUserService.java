package com.gdpi.ssm.service;

import com.gdpi.ssm.domain.UserInfo;


import java.util.List;

public interface IUserService{
    List<UserInfo> findAll();
    void save(UserInfo userInfo) throws Exception;
}
