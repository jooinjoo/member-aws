package com.grepp.memberaws.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberCreateRequest {

    private String email;

    private String password;

    private String name;

    private String phone;
}
