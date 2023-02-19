package com.example.planner.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.planner.form.ActivityForm;
import com.example.planner.models.Activity;
import com.example.planner.repositories.ActivityRepositorie;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepositorie activityRepositorie;

    public List<Activity> get(){
        LocalDate date = LocalDate.now(); 
        List<Activity> todoList= activityRepositorie.findAll();
        // for(Activity todo:todoList){
        //     // if(todo.getDate().g)
        // }
        return todoList;
    }
    public void create(ActivityForm form){
        if (form.getName()!="" && form.getDate()!=null){
            Activity activity = new Activity();
            activity.setName(form.getName());
            activity.setDate(form.getDate());
            activityRepositorie.save(activity);
        }
    }
    public void update(ActivityForm form){
        System.out.println(form.getName());
        if (form.getName()!="" && form.getDate()!=""){
            Activity activity = new Activity();
            activity.setId(form.getId());
            activity.setName(form.getName());
            activity.setDate(form.getDate());
            activityRepositorie.save(activity);
        }
    }
    public void delete(int id){
        activityRepositorie.deleteById(id);
    }
}
