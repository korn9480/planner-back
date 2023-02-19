package com.example.planner.testActivityService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.planner.services.ActivityService;

@SpringBootTest
public class TestGet {
    @Autowired
    ActivityService obj;

    @Test
    public void Test(){
        assertNotEquals(obj.get(),null);
    }

    
}
