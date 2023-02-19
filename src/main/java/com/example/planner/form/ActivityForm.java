package com.example.planner.form;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ActivityForm {
    private int id;
    private String name;
    private String date;
}
