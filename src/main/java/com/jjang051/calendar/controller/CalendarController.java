package com.jjang051.calendar.controller;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/json-list")
    @ResponseBody
    public List<CalendarDto> jsonList() {
        return calendarService.getAllTodo();
    }

//    @PostMapping("/insert")
//    @ResponseBody
//    public String insert(@ModelAttribute CalendarDto calendarDto) {
//        //localhost:8081/calendar/insert?title=점심약속
//        log.info("calendarDto==={}",calendarDto);
//        return "fdfsds";
//    }
    @PostMapping("/insert")
    @ResponseBody
    public Map<String, String> insert(@RequestBody CalendarDto calendarDto) {
        log.info("calendarDto==={}",calendarDto);
        int result = calendarService.insertCalendar(calendarDto);
        Map<String, String> resultMap = new HashMap<>();
        if(result>0) {
            resultMap.put("isInsert","ok");
        } else {
            resultMap.put("isInsert","fail");
        }
        return resultMap;
    }
    @PutMapping("/update")
    @ResponseBody
    public Map<String, String> update(@RequestBody CalendarDto calendarDto) {
        log.info("calendarDto==={}",calendarDto);
        int result = calendarService.updateCalendar(calendarDto);
        Map<String, String> resultMap = new HashMap<>();
        if(result>0) {
            resultMap.put("isInsert","ok");
        } else {
            resultMap.put("isInsert","fail");
        }
        return resultMap;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Map<String, String> delete(@RequestBody CalendarDto calendarDto) {
        log.info("calendarDto==={}",calendarDto);
        int result = calendarService.deleteCalendar(calendarDto);
        Map<String, String> resultMap = new HashMap<>();
        if(result>0) {
            resultMap.put("isInsert","ok");
        } else {
            resultMap.put("isInsert","fail");
        }
        return resultMap;
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String, String> delete(@PathVariable int id) {
        log.info("id==={}",id);
        //int result = calendarService.deleteCalendar(calendarDto);
        int result = calendarService.deleteCalendar02(id);
        Map<String, String> resultMap = new HashMap<>();
        if(result>0) {
            resultMap.put("isInsert","ok");
        } else {
            resultMap.put("isInsert","fail");
        }
        return resultMap;
    }
}
