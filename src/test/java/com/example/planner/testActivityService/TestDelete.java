package com.example.planner.testActivityService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.planner.repositories.ActivityRepositorie;
import com.example.planner.services.ActivityService;

@SpringBootTest
public class TestDelete {
    
    @Autowired
    private ActivityService obj;

    @Autowired
    private ActivityRepositorie repositorie;

    @Test
    public void test1(){
        int indexTest = obj.get().size()-1;
        obj.delete(indexTest);
        assertEquals(repositorie.findById(indexTest).isEmpty(), true);


    }
}
