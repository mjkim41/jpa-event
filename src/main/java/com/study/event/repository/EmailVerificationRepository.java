package com.study.event.repository;

import com.study.event.domain.eventUser.entity.EmailVerification;
import jakarta.persistence.JoinColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {

}
