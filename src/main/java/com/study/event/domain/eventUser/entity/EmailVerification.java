package com.study.event.domain.eventUser.entity;

import com.study.event.domain.event.entity.Event;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_email_verification")
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_id")
    private Long id;

    // 제일 앞자리가 0일수도 있으므로, string으로 저장함
    @Column(nullable = false)
    private String verificationCode; // 인증코드

    @Column(nullable = false)
    private LocalDateTime expiryDate; // 인증 만료 시간

    // 연관관계 설정
    @OneToOne
    @JoinColumn(name = "event_user_id", referencedColumnName = "ev_user_id")
    private EventUser eventUser;

    public void updateNewCode(String newCode) {
        this.verificationCode = newCode;
        this.expiryDate = LocalDateTime.now().plusMinutes(5);
    }
}
