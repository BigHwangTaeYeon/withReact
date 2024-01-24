package com.example.demo.domain.LG0010.serviceImpl;

import com.example.demo.domain.LG0010.dao.LG0010Dao;
import com.example.demo.domain.LG0010.dto.LG0010Dto;
import com.example.demo.domain.LG0010.dto.LG0011Dto;
import com.example.demo.domain.LG0010.service.LG0010Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

@Service("loginServiceImpl")
public class LG0010ServiceImpl implements LG0010Service, UserDetailsService {
    private final LG0010Dao loginMapper;

    @Autowired
    public LG0010ServiceImpl(LG0010Dao loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        LG0010Dto user = loginMapper.findByUsername(username);

        if (user == null) {
            // user가 null인 경우 예외 발생
            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        }

        // 유저의 권한을 설정하는 부분
        return new org.springframework.security.core.userdetails.User(user.getMember_id(), user.getMember_password(), new ArrayList<>());
    }

    public LG0011Dto checkLoin(String username, String password) throws LoginException {
        LG0011Dto user = loginMapper.findByUsername2(username);

        if (user == null) {
            // user가 null인 경우 예외 발생
            throw new LoginException("유저를 찾을 수 없습니다.");
        }
        // password 암호화

        // password check
        if(!password.equals(user.getMember_password()))
            throw new LoginException("password error");

        return user;
    }
}
