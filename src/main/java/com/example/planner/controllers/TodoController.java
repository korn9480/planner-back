package com.example.planner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.planner.form.ActivityForm;
import com.example.planner.models.Activity;
import com.example.planner.services.ActivityService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequiredArgsConstructor
public class TodoController {
    // @Autowired 
    private final ActivityService activityService;
    @GetMapping("/getTodoList")
    public ResponseEntity<List<Activity>> index(Model model){
        System.out.println("dddd");
        List<Activity> activities = activityService.get();
        // model.addAttribute("activitys", activities);
        return new ResponseEntity<List<Activity>>(activities,HttpStatus.OK);
    }
    @PostMapping(path = "/create")
    public HttpStatus newActivity(@RequestBody ActivityForm form){
        activityService.create(form);
        return HttpStatus.OK;
    }
    @PutMapping("/edit")
    public HttpStatus updateActivity(@RequestBody ActivityForm form){
        activityService.update(form);
        return HttpStatus.OK;
    }
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteActivity(@PathVariable("id") int id ){
        // System.out.println(id);
        activityService.delete(id);
        return HttpStatus.OK;
    }
}
