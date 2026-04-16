package com.example.resis.service;

import com.example.resis.dto.InsertTaskTypeDto;
import com.example.resis.model.TaskType;
import com.example.resis.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskTypeService {

    @Autowired
    public TaskTypeRepository taskTypeRepository;

    public TaskType insertTaskTypeInfo(InsertTaskTypeDto req){

        TaskType taskType = new TaskType();
        taskType.setTaskName(req.getTaskName());
        taskType.setCreatedAt(LocalDateTime.now());
        taskType.setCreatedBy(1L);
        return taskTypeRepository.save(taskType);
    }

    public List<TaskType> selectTaskTypeInfo(){
        return taskTypeRepository.findAll();
    }

    public Optional<TaskType> selectTaskTypeInfoById(Long id){
        return taskTypeRepository.findById(id);
    }

    public TaskType updateTaskTypeInfo(InsertTaskTypeDto req, Long id){

        Optional<TaskType> taskType = taskTypeRepository.findById(id);
        if(taskType.isPresent()){
            TaskType taskType1 = taskType.get();
            taskType1.setTaskName(req.getTaskName());
            taskType1.setUpdatedAt(LocalDateTime.now());
            taskType1.setUpdatedBy(2L);
            return taskTypeRepository.save(taskType1);
        }else {
            return null;
        }
    }
}
