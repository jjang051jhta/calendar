package com.jjang051.calendar.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalendarDto {
    private int id;
    private String title;
    private String start;
    private String end;
}
