package com.example.demo.domain.LG0010.serviceImpl;

import com.example.demo.domain.LG0010.dao.LG0010Dao;
import com.example.demo.domain.LG0010.dto.LG0010Dto;
import com.example.demo.domain.LG0010.dto.LG0011Dto;
import com.example.demo.domain.LG0010.service.LG0010Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Optional;

@Service("loginServiceImpl")
public class LG0010ServiceImpl implements LG0010Service, UserDetailsService {

    private final LG0010Dao loginMapper;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LG0010ServiceImpl(LG0010Dao loginMapper, PasswordEncoder bCryptPasswordEncoder) {
        this.loginMapper = loginMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveFromLogin(LG0011Dto memberDTO) throws LoginException, NullPointerException{
        Optional<LG0010Dto> userCheck = Optional.ofNullable(loginMapper.findByUsername(memberDTO.getMember_id()));
        if(!ObjectUtils.isEmpty(userCheck)){
            throw new LoginException("아이디를 이미 사용하고 있습니다.");
        }
        memberDTO.setMember_password(bCryptPasswordEncoder.encode(memberDTO.getMember_password()));
//        memberDTO.hashPassword(bCryptPasswordEncoder);
        loginMapper.saveFromLogin(memberDTO);
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

        // password check
        if(!bCryptPasswordEncoder.matches(password, user.getMember_password())){
            throw new LoginException("password error");
        }
        return user;
    }
}
