package com.example.planner.testActivityService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.planner.form.ActivityForm;
import com.example.planner.models.Activity;
import com.example.planner.repositories.ActivityRepositorie;
import com.example.planner.services.ActivityService;

@SpringBootTest
public class TestUpdate {
    @Autowired
    private ActivityRepositorie repositorie;

    @Autowired
    private ActivityService service;
    
    // T T
    @Test
    public void Test1(){
        ActivityForm form = new ActivityForm();
        form.setName("eat food");
        form.setDate("2023-2-21");
        service.create(form);

        int activity = service.get().size();
        Activity model = service.get().get(activity-1);
        ActivityForm form_up= new ActivityForm();
        form_up.setId(model.getId());
        form_up.setName("go to school");
        form_up.setDate("2023-2-21");
        service.update(form_up);

        Optional<Activity> activity_op = repositorie.findById(model.getId());
        Activity updata = activity_op.get();
        assertNotEquals(model,updata);
    }
    
    // T F
    @Test
    public void Test2(){
        ActivityForm form = new ActivityForm();
        form.setName("eat food");
        form.setDate("2023-2-21");
        service.create(form);

        int activity = service.get().size();
        Activity model = service.get().get(activity-1);
        ActivityForm form_up= new ActivityForm();
        form_up.setId(model.getId());
        form_up.setName("go to school");
        form_up.setDate("");
        service.update(form_up);

        Optional<Activity> activity_op = repositorie.findById(model.getId());
        Activity updata = activity_op.get();
        assertEquals(model.getName(),updata.getName());
    }

    // F T
    @Test
    public void Test3(){
        ActivityForm form = new ActivityForm();
        form.setName("eat food");
        form.setDate("2023-2-21");
        service.create(form);

        int activity = service.get().size();
        Activity model = service.get().get(activity-1);
        ActivityForm form_up= new ActivityForm();
        form_up.setId(model.getId());
        form_up.setName("");
        form_up.setDate("2023-3-15");
        service.update(form_up);

        Optional<Activity> activity_op = repositorie.findById(model.getId());
        Activity updata = activity_op.get();
        assertEquals(model.getDate(),updata.getDate());
        assertEquals(model.getName(),updata.getName());
    }

    // F F
    @Test
    public void Test4(){
        ActivityForm form = new ActivityForm();
        form.setName("");
        form.setDate("");
        service.create(form);

        int activity = service.get().size();
        Activity model = service.get().get(activity-1);
        ActivityForm form_up= new ActivityForm();
        form_up.setId(model.getId());
        form_up.setName("");
        form_up.setDate("");
        service.update(form_up);

        Optional<Activity> activity_op = repositorie.findById(model.getId());
        Activity updata = activity_op.get();
        assertEquals(model.getName(),updata.getName());
        assertEquals(model.getDate(),updata.getDate());
    }
}
