package com.jjang051.calendar.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CalendarDto {
    private int id;
    private String title;
    private String start;
    private String end;
    private String startTime;
    private String endTime;
    private boolean allDay;
}
