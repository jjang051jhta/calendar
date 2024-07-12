package com.jjang051.calendar.controller;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;
    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("calendarDto", new CalendarDto());
        return "calendar/insert";
    }

    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute CalendarDto calendarDto) {
        CalendarDto sendCalendarDto =null;
        if(calendarDto.getStartTime().isBlank()) {
            calendarDto.setStartTime("00:00");
        }
        if(calendarDto.getEndTime().isBlank()) {
            calendarDto.setEndTime("00:00");
        }

        sendCalendarDto = CalendarDto.builder()
                .start(calendarDto.getStart()+" "+calendarDto.getStartTime())
                .end(calendarDto.getEnd()+" "+calendarDto.getStartTime())
                .title(calendarDto.getTitle())
                .allDay(calendarDto.isAllDay())
                .build();
        log.info("sendCalendarDto==={}",sendCalendarDto.toString());
        calendarService.insertCalendar(sendCalendarDto);
        log.info("===={}",sendCalendarDto.isAllDay());
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<CalendarDto> calendarDtoList  = calendarService.getAllTodo();
        model.addAttribute("calendarDtoList",calendarDtoList);
        return "calendar/index";
    }
    @PostMapping("/json-list")
    @ResponseBody
    public List<CalendarDto> jsonList(@ModelAttribute CalendarDto calendarDto, Model model) {
        CalendarDto sendCalendarDto =null;
        if(calendarDto.getStartTime().isEmpty()) {
            calendarDto.setStartTime("00:00");
        }
        if(calendarDto.getEndTime().isEmpty()) {
            calendarDto.setEndTime("00:00");
        }

        sendCalendarDto = CalendarDto.builder()
                .start(calendarDto.getStart()+" "+calendarDto.getStartTime())
                .end(calendarDto.getEnd()+" "+calendarDto.getStartTime())
                .title(calendarDto.getTitle())
                .allDay(calendarDto.isAllDay())
                .build();
        calendarService.insertCalendar(sendCalendarDto);
        List<CalendarDto> calendarDtoList  = calendarService.getAllTodo();
        return calendarDtoList;
    }
}
