package com.example.demo.domain.BA0010.dao;

import com.example.demo.domain.BA0010.dto.BA0010Dto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BA0010")
public class BA0010Dao {

    private final SqlSessionTemplate sqlSession;

    @Autowired
    public BA0010Dao(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BA0010Dto> getApi() throws Exception {
        return sqlSession.selectList("BA0010.getapi");
    }

}
