package com.example.planner.testActivityService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.planner.form.ActivityForm;
import com.example.planner.services.ActivityService;

@SpringBootTest
public class TestCreate{
    @Autowired
    ActivityService obj = new ActivityService();

    @Test
    // T T
    public void Test1(){
        int activity = obj.get().size();
        ActivityForm form = new ActivityForm();
        form.setName("eat food");
        form.setDate("21-3-2021");
        obj.create(form);
        assertEquals(obj.get().size(), activity+1);
    }
    // F T
    public void Test2(){
        int activity = obj.get().size();
        ActivityForm form = new ActivityForm();
        // form.setName("eat food");
        form.setDate("21-3-2021");
        obj.create(form);
        assertEquals(obj.get().size(), activity);

    }
     // T F
    public void Test3(){
        int activity = obj.get().size();
        ActivityForm form = new ActivityForm();
        form.setName("eat food");
        // form.setDate("2023-2-21");
        obj.create(form);
        assertEquals(obj.get().size(), activity);
    }
    // F F
    public void Test4(){
        int activity = obj.get().size();
        ActivityForm form = new ActivityForm();
        // form.setName("eat food");
        // form.setDate("2023-2-21");
        obj.create(form);
        assertEquals(obj.get().size(), activity+1);

    }

}