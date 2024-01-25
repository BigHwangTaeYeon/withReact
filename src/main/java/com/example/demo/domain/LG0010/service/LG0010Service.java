package com.example.demo.domain.LG0010.service;

import com.example.demo.domain.LG0010.dto.LG0011Dto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.security.auth.login.LoginException;

public interface LG0010Service {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    LG0011Dto checkLoin(String username, String password) throws LoginException;

    void saveFromLogin(LG0011Dto memberDTO) throws LoginException;
}
