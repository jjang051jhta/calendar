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
    @GetMapping("/json-list")
    @ResponseBody
    public List<CalendarDto> jsonList(Model model) {
        List<CalendarDto> calendarDtoList  = calendarService.getAllTodo();
        model.addAttribute("calendarDtoList",calendarDtoList);
        return calendarDtoList;
    }

}
