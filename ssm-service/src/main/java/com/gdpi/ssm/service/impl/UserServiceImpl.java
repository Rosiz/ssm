package com.gdpi.ssm.service.impl;

import com.gdpi.ssm.dao.IUserDao;

import com.gdpi.ssm.domain.Role;
import com.gdpi.ssm.domain.UserInfo;
import com.gdpi.ssm.service.IUserService;
import com.gdpi.ssm.util.BCryptPasswordEncoderUtils;
import com.gdpi.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserInfo userInfo=null;
//        try {
//            userInfo = iUserDao.findByUsername(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
//        return user;
//    }
//    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        for(Role role:roles) {
//            list.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        return list;
//    }

    @Override
    public List<UserInfo> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setId(DateUtil.getUUID());
        iUserDao.save(userInfo);
    }
}
