package com.example.resis.controller;

import com.example.resis.dto.InsertTaskTypeDto;
import com.example.resis.model.TaskType;
import com.example.resis.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/taskType")
public class TaskTypeController {

    @Autowired
    private TaskTypeService taskTypeService;

    @PostMapping
    public TaskType insertTaskTypeInfo(@RequestBody InsertTaskTypeDto req){
        return taskTypeService.insertTaskTypeInfo(req);
    }

    @GetMapping
    public List<TaskType> selectTaskTypeInfo(){
        return taskTypeService.selectTaskTypeInfo();
    }

    @GetMapping("/{id}")
    public Optional<TaskType> selectTaskTypeInfoById(Long id){
        return taskTypeService.selectTaskTypeInfoById(id);
    }

    @PutMapping("/{id}")
    public TaskType updateTaskInfo(@RequestBody InsertTaskTypeDto req, Long id){
        return taskTypeService.updateTaskTypeInfo(req, id);
    }
}
