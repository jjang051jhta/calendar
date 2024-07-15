package com.jjang051.calendar.dao;

import com.jjang051.calendar.dto.CalendarDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarDao {
    int insertCalendar(CalendarDto calendarDto);
    List<CalendarDto> getAllTodo();

    int updateCalendar(CalendarDto calendarDto);

    int deleteCalendar(CalendarDto calendarDto);

    int deleteCalendar02(int id);
}
