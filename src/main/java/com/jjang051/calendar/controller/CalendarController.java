package com.jjang051.calendar.controller;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        CalendarDto sendCalendarDto = CalendarDto.builder()
                .start(calendarDto.getStart()+" "+calendarDto.getStartTime())
                .end(calendarDto.getEnd()+" "+calendarDto.getEndTime())
                .title(calendarDto.getTitle())
                .allDay(calendarDto.isAllDay())
                .build();
        log.info("sendCalendarDto==={}",sendCalendarDto.toString());
        calendarService.insertCalendar(sendCalendarDto);
        //log.info("===={}",calendarDto.isAllDay() ? 'Y':'N');
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<CalendarDto> calendarDtoList  = calendarService.getAllTodo();
        model.addAttribute("calendarDtoList",calendarDtoList);
        return "calendar/index";
    }

}
