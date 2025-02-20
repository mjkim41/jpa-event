package com.study.event.controller;

import com.study.event.service.EventUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
@Slf4j
@RequiredArgsConstructor
public class EventUserController {

    private final EventUserService eventUserService;

    // email 중복확인 API 생성
    @GetMapping("/check-email")
    public ResponseEntity<?> checkEmail(String email) {

        boolean isDuplicate = eventUserService.checkEmailDuplicate(email);

        String message = isDuplicate ? "이메일이 중복되었습니다." : "사용 가능한 이메일입니다.";

        return ResponseEntity.ok().body(Map.of(
                "isDuplicate", isDuplicate,
                "message", message
        ));

    }



}
