package com.gdpi.ssm.service;

import com.gdpi.ssm.domain.UserInfo;

public interface IGlobalService {
    UserInfo login(String username, String password) throws Exception;
}
