package com.cement.CodysseyBackend.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "login_type")
    private String loginType;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Timestamp update_at;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Member(String email, String password, String username,
                  String phoneNumber, String gender, String loginType, boolean isDeleted) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.loginType = !loginType.isEmpty() ? loginType : "";
        this.isDeleted = false;
    }
}
