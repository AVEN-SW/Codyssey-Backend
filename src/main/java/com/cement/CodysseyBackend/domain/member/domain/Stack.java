package com.cement.CodysseyBackend.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "stack")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Stack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long stackId;

    @Column(name = "member_id", updatable = false)
    private Long memberId;

    @Column(name = "stack", nullable = false, unique = true)
    private String stack;

    @Builder
    public Stack(Long memberId, String stack) {
        this.memberId = memberId;
        this.stack = stack;
    }
}
