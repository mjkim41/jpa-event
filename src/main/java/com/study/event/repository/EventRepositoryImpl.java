package com.study.event.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.event.domain.event.entity.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;

import java.util.List;

import static com.study.event.domain.event.entity.QEvent.event;

@RequiredArgsConstructor
@Slf4j
public class EventRepositoryImpl implements EventRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public Slice<Event> findEvents(String sort, Pageable pageable) {

        OrderSpecifier<?> orderSpecifier;
        switch (sort) {
            case "id":
                orderSpecifier = event.id.desc();
                break;
            case "title":
                orderSpecifier = event.title.asc();
                break;
            default:
                orderSpecifier = event.date.desc();
        }

        List<Event> eventList = factory
                .selectFrom(event)
                .orderBy(orderSpecifier)
                .limit(pageable.getPageSize() + 1)
                .offset(pageable.getOffset())
                .fetch()
                ;

        // 추가 데이터 있는지 확인
        boolean hasNext = false;
        if (eventList.size() > pageable.getPageSize()) {
            hasNext = true;
            eventList.remove(eventList.size() - 1);
        }

        return new SliceImpl<>(eventList, pageable, hasNext);

    }
}