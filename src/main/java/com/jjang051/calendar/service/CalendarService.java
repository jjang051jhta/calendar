package com.jjang051.calendar.service;

import com.jjang051.calendar.dao.CalendarDao;
import com.jjang051.calendar.dto.CalendarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {
    private final CalendarDao calendarDao;
    public int insertCalendar(CalendarDto calendarDto) {
        return calendarDao.insertCalendar(calendarDto);
    }

    public List<CalendarDto> getAllTodo() {
        return calendarDao.getAllTodo();
    }
}
