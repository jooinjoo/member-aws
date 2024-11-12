package com.grepp.memberaws.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberUpdateRequest {

    private String password;

    private String phone;
}
