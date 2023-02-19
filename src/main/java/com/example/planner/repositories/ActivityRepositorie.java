package com.example.planner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.planner.models.Activity;

public interface ActivityRepositorie extends JpaRepository<Activity,Integer>{
    
}
