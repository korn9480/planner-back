package com.example.planner.testActivityService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.planner.services.ActivityService;

@SpringBootTest
public class TestCkeckDate {
    ActivityService obj = new ActivityService();
    /*  if  n = 1
            if  n=2
            if  n=2
            if  n=1
        คำนวณ test case (2**1)+(2**2)+(2**2)+(2**1)
                        = 2+ 4+4+2
                        = 12 case โดยประมาณ
    */

    // ข้อมูลวันที่ถูกหมด
    @Test
    public void test1(){
        assertEquals(obj.checkDate("21-2-2023"),true);
    }

    // กรอกปีผิดคือปี น้อยกว่า 1
    @Test
    public void test2(){
        assertEquals(obj.checkDate("21-2-0"),false);
    }

    // กรอกเดือนผิดคือปี น้อยกว่า 1
    @Test
    public void test3(){
        assertEquals(obj.checkDate("21-0-2023"),false);
    }

    // กรอกเดือนผิดคือปี มากกว่า 12
    @Test
    public void test4(){
        assertEquals(obj.checkDate("21-13-2023"),false);
    }

    // กรอกวันที่ผิดคือปี น้อยกว่า 1
    @Test
    public void test5(){
        assertEquals(obj.checkDate("0-2-2023"),false);
    }

    // กรอกวันผิดคือปี น้อยกว่า 31
    @Test
    public void test6(){
        assertEquals(obj.checkDate("32-2-2023"),false);
    }

    // กรอกข้อมูลไม่ครบ
    @Test
    public void test7(){
        assertEquals(obj.checkDate("2-2"),false);
    }
}
