package com.example.demo.domain.LG0010.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// LoginDTO
public class LG0010Dto {
    private String member_id; // id
    private String member_password; // password

    public LG0010Dto() {}

    public LG0010Dto(String userId, String userPw) {
        this.member_id = userId;
        this.member_password = userPw;
    }

    public LG0010Dto(LG0011Dto memberDTO) {
        this.member_id = memberDTO.getMember_id();
        this.member_password = memberDTO.getMember_password();
    }
}
