package com.cement.CodysseyBackend.domain.member.repository;

import com.cement.CodysseyBackend.domain.member.domain.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
}
