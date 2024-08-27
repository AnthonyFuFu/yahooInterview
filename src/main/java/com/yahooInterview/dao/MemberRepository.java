package com.yahooInterview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yahooInterview.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}