package com.grepp.memberaws.controller;

import com.grepp.memberaws.dto.MemberCreateRequest;
import com.grepp.memberaws.dto.MemberResponse;
import com.grepp.memberaws.dto.MemberUpdateRequest;
import com.grepp.memberaws.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/v1")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberCreateRequest request) {
        return ResponseEntity.ok(memberService.saveMember(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.readMember(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> modifyMember(@PathVariable Long id, @RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok(memberService.updateMember(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.deleteMember(id));
    }
}