package com.example.demo.domain.LG0010.dao;

import com.example.demo.domain.LG0010.dto.LG0010Dto;
import com.example.demo.domain.LG0010.dto.LG0011Dto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
// LoginMapper
public interface LG0010Dao {
    //로그인을 할 때 회원정보 조회 필요 id = #{member_id}이 부분은 실제 컬럼이랑 동일해야함
    LG0010Dto findByUsername(@Param("member_id") String username);

    LG0011Dto findByUsername2(@Param("member_id") String username);

    void saveFromLogin(LG0011Dto memberDTO);

    // 게시물 목록 조회
//    List<BoardDto> selectBoardList(BoardDto bdto);
}
