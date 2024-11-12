package com.grepp.memberaws.service;

import com.grepp.memberaws.dto.MemberCreateRequest;
import com.grepp.memberaws.dto.MemberResponse;
import com.grepp.memberaws.dto.MemberUpdateRequest;

import java.util.List;

public interface MemberService {

    MemberResponse saveMember(MemberCreateRequest request);

    MemberResponse readMember(Long id);

    MemberResponse updateMember(Long id, MemberUpdateRequest request);

    String deleteMember(Long id);

    List<MemberResponse> readAllMembers();
}
