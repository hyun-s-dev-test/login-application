package com.dev.woo.toyproject.login.loginserver.domain.term;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermRepository extends JpaRepository<Term, Long> {
    List<Term> findAllByActiveOrderByOrderNumAsc(Long active);
}