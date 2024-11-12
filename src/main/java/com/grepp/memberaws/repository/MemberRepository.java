package com.grepp.memberaws.repository;

import com.grepp.memberaws.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
