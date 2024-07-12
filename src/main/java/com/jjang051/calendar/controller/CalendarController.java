package com.jjang051.calendar.controller;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;
    @GetMapping("/insert")
    public String insert() {
        return "calendar/insert";
    }

    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute CalendarDto calendarDto) {
        calendarService.insertCalendar(calendarDto);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<CalendarDto> calendarDtoList  = calendarService.getAllTodo();
        model.addAttribute("calendarDtoList",calendarDtoList);
        return "calendar/index";
    }

}
