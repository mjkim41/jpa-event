package com.study.event.service;

import com.study.event.domain.event.dto.request.EventCreate;
import com.study.event.domain.event.entity.Event;
import com.study.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    // 전체 조회
    @Transactional(readOnly = true)
    public List<Event> getEvents() {
        return eventRepository.findAll();
    };

    // 이벤트 등록
    public void saveEvent(EventCreate dto) {
        eventRepository.save(dto.toEntity());
    }

}
