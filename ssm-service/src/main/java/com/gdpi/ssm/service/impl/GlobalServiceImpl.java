package com.gdpi.ssm.service.impl;

import com.gdpi.ssm.dao.IUserDao;
import com.gdpi.ssm.domain.UserInfo;
import com.gdpi.ssm.service.IGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GlobalServiceImpl implements IGlobalService {
    @Autowired
    private IUserDao iUserDao;
    public UserInfo login(String username, String password) throws Exception {
        UserInfo user = iUserDao.findByUsername(username);
        if(user!=null&&user.getPassword().equals(password)){
            return user;
        }else{
            return null;
        }
    }
}
