package com.grepp.memberaws.dto;

import com.grepp.memberaws.entity.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponse {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String phone;

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .phone(member.getPhone())
                .build();
    }
}
