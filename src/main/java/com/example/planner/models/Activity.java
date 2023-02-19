package com.example.planner.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "activity")
@Getter @Setter
public class Activity {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String date;
}
