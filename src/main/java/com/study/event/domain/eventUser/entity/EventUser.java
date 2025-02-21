package com.study.event.domain.eventUser.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_event_user")
public class EventUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ev_user_id")
    private Long id;

    @Column(name = "ev_user_email", nullable = false, unique = true)
    private String email;

    // Not Null 안 거는 이유 : SNS 로그인한 회원
    @Column(length=500)
    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.COMMON;

//    @CreationTimestamp (회원가입을 위한 인증코드 보낼 때는 설정 안되게)
    private LocalDateTime createdAt;

    // 이메일 인증 완료헀는지 여부
    @Column(nullable = false)
    private boolean emailVerified;

    // 이메일 인증 완료여부를 변경해주는 편의메소드
    public void emailVerify() {
        this.emailVerified = true;
    }

}
