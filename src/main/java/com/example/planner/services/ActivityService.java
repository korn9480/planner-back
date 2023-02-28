package com.example.planner.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

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
    public HttpStatus create(ActivityForm form){
        boolean result = this.checkDate(form.getDate());
        if (result){
            if (!form.getName().isEmpty()){
                form.setDate(form.getDate().replace("/", "-"));
                Activity activity = new Activity();
                activity.setName(form.getName());
                activity.setDate(form.getDate());
                activityRepositorie.save(activity);
                return HttpStatus.OK;

            }
        }
        return HttpStatus.FAILED_DEPENDENCY;

    }
    public HttpStatus update(ActivityForm form){
        // System.out.println(form.getName());
        boolean result = this.checkDate(form.getDate());
        if (result){
            if (!form.getName().isEmpty()){
                form.setDate(form.getDate().replace("/", "-"));
                Activity activity = new Activity();
                activity.setId(form.getId());
                activity.setName(form.getName());
                activity.setDate(form.getDate());
                activityRepositorie.save(activity);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.FAILED_DEPENDENCY;
    }
    public void delete(int id){
        activityRepositorie.deleteById(id);
    }

    public boolean checkDate(String date_str){
        date_str = date_str.replace("/", "-");
        String[] dateArray = date_str.split("-");
        if(dateArray.length == 3){
            int day = Integer.parseInt(dateArray[0]);
            if (day<1 || day>31){
                return false;
            }
            int month = Integer.parseInt(dateArray[1]);
            if (month<1 || month>12){
                return false;
            }
            int year = Integer.parseInt(dateArray[2]);
            if (year<1){
                return false;
            }
            return true;

        }
        else{
            return false;
        }
    }
}