package com.todolist.todolist.controller;

import com.todolist.todolist.models.Task;
import com.todolist.todolist.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    ITaskService service;


    @PostMapping("/tasks")
    public String createTask(@RequestBody Task task){
        service.createTask(task);

        return "Task created succesfully";
    }


    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }



    @PutMapping("/tasks/{id}")
    public String editTask(@PathVariable Long id, @RequestBody Task task){
        service.editTask(id,task);

        return "Task edited.";
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);

        return "Task deleted succesfully";
    }



}
