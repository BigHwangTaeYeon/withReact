package com.example.demo.domain.LG0010.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LG0010Controller {
    // react와 spring에서 서로 다른 세션을 공통 정보를 가지고 있는 JWT를 통해 가져와 매칭합니다.
    // 개념 https://lms0806.tistory.com/112
    // 구현 https://velog.io/@prettylee620/%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83-jwt-mybatis-mysql-springboot
}
