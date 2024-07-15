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

    @GetMapping("/list")
    public String list() {
        return "calendar/index";
    }

}
