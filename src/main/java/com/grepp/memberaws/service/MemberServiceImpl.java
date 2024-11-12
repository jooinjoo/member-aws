package com.grepp.memberaws.service;

import com.grepp.memberaws.dto.MemberCreateRequest;
import com.grepp.memberaws.dto.MemberResponse;
import com.grepp.memberaws.dto.MemberUpdateRequest;
import com.grepp.memberaws.entity.Member;
import com.grepp.memberaws.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponse saveMember(MemberCreateRequest request) {
        return MemberResponse.from(memberRepository.save(Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .phone(request.getPhone())
                .build()));
    }

    @Override
    public MemberResponse readMember(Long id) {
        return MemberResponse.from(memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Member")));
    }

    @Override
    public MemberResponse updateMember(Long id, MemberUpdateRequest request) {
        Member foundMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Member"));
        foundMember.setPassword(request.getPassword());
        foundMember.setPhone(request.getPhone());
        return MemberResponse.from(foundMember);
    }

    @Override
    public String deleteMember(Long id) {
        Member foundMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Member"));
        memberRepository.delete(foundMember);
        return "Delete Member. id=" + id;
    }

    @Override
    public List<MemberResponse> readAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .toList();
    }
}
